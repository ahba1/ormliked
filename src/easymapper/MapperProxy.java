package easymapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {

    private final Class<?> clazz;

    public MapperProxy(Class<?> clazz){
        this.clazz = clazz;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
