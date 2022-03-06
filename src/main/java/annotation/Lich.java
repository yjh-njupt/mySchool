package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(value = RetentionPolicy.CLASS)
@Target(value = {ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface Lich {
    int value() default 1;

    String id() default "努力学习";
}
