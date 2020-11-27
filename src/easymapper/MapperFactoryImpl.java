package easymapper;

import easymapper.core.IMapperProxyFactory;

public class MapperFactoryImpl implements IMapperProxyFactory {

    @Override
    public <T> T createMapperProxy(Class<?> clazz) {
        return (T)new MapperProxy(clazz);
    }


    public static IMapperProxyFactory getFactory(){
        IMapperProxyFactory res = null;
        try {
            res = MapperFactoryImpl.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return res;
    }
}
