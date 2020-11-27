package easymapper.core;

import java.sql.ResultSet;
import java.util.List;

/**
 * EasyMapper的注解解析器
 */
public interface IResolver<T> {

    /**
     * 解析Bean中的域属性
     * @param clazz 需要解析的类（需要使用MapperBean进行注解）
     */
    void resolve(Class<T> clazz);

    /**
     * 解析数据库返回值
     * @param set
     */
    List<T> resolveResult(ResultSet set);
}
