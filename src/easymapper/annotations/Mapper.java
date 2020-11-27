package easymapper.annotations;

import java.lang.annotation.*;

/**
 * Mapper注解
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mapper {

    String value();
}
