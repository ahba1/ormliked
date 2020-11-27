package easymapper.annotations;

import java.lang.annotation.*;

/**
 * 映射类域属性注解
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapperField {

    String value();
}
