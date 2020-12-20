package learn.reflection.spring.annotation;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(CompotentScans.class)
public @interface CompotentScan {
    public String value();
}
