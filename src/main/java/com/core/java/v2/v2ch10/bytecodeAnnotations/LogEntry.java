package com.core.java.v2.v2ch10. bytecodeAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The interface Log entry.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogEntry
{
   /**
    * Logger string.
    *
    * @return the string
    */
   String logger();
}
