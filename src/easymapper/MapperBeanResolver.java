package easymapper;

import easymapper.annotations.MapperBean;
import easymapper.annotations.MapperField;
import easymapper.core.IResolver;
import easymapper.exception.WrongMapperBeanException;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MapperBeanResolver<T> implements IResolver<T> {

    private Map<String, Field> map = new HashMap<>();
    private Class<T> clazz;

    public MapperBeanResolver(Class<T> clazz){
        this.clazz = clazz;
        resolve(clazz);
    }

    private boolean check(Class<T> clazz){
        return clazz.isAnnotationPresent(MapperBean.class);
    }

    @Override
    public void resolve(Class<T> clazz) {
        if (check(clazz)){
            MapperBean mapperBean = clazz.getAnnotation(MapperBean.class);
            if ("".equals(mapperBean.value())){
                simpleMap(clazz, mapperBean.value());
            }else{
                map(clazz);
            }
        }else {
            throw new WrongMapperBeanException(clazz);
        }
    }

    @Override
    public List<T> resolveResult(ResultSet set) {
        List<T> res = Collections.synchronizedList(new LinkedList<>());

        try {
            while (set.next()){
                T bean = clazz.newInstance();
                for (Map.Entry<String, Field> entry:map.entrySet()){
                    entry.getValue().setAccessible(true);
                    entry.getValue().set(bean, set.getObject(entry.getKey()));
                }
                res.add(bean);
            }
        }catch (InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    private void map(Class<T> clazz){
        Field[] fields = clazz.getFields();
        for (Field field:fields){
            if (!field.isAnnotationPresent(MapperField.class)){
                continue;
            }
            String key = field.getAnnotation(MapperField.class).value();
            map.put(key, field);
        }
    }

    private void simpleMap(Class<T> clazz, String table){
        String[] cols = EasyLoadCenter.getInstance().getTableColName(table);
        for (String col:cols){
            try {
                Field field = clazz.getField(col);
                map.put(col, field);
            } catch (NoSuchFieldException e) {
            }
        }
    }
}
