package easymapper.core;

/**
 * Mapper代理对象工厂
 */
public interface IMapperProxyFactory {

    /**
     * 生成Mapper代理对象
     * @param clazz 需要生产的Mapper类
     * @return Mapper代理对象
     */
    <T> T createMapperProxy(Class<?> clazz);
}
