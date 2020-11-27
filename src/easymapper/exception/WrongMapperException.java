package easymapper.exception;

public class WrongMapperException extends BaseException {

    public WrongMapperException(String msg){
        super(msg);
    }

    public WrongMapperException(Class<?> clazz){
        this("the class "+clazz.getName()+" is not a mapper");
    }
}
