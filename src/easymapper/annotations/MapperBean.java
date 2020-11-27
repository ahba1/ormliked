package easymapper.annotations;

import java.lang.annotation.*;

/**
 * 映射类注解
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapperBean {

    String value() default "";
}
