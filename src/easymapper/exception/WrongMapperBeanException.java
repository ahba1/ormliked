package easymapper.exception;

public class WrongMapperBeanException extends BaseException {


    public WrongMapperBeanException(String msg) {
        super(msg);
    }

    public WrongMapperBeanException(Class<?> clazz){
        this("the class "+clazz.getName()+" is not a mapper bean");
    }
}
