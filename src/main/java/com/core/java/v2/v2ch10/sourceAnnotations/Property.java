package com.core.java.v2.v2ch10. sourceAnnotations;
import java.lang.annotation.*;

/**
 * The interface Property.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Property
{
   /**
    * Editor string.
    *
    * @return the string
    */
   String editor() default "";
}
