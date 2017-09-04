package com.java.annotion;


import java.lang.annotation.*;

/**
 * 元数据
 * The interface Exec inde.
 */

@Target({ElementType.FIELD,ElementType.METHOD}) //10种注解范围
@Retention(RetentionPolicy.RUNTIME)  //三种注解保留方式
@Inherited  //表明该注解将会被子类继承
@Documented  //表明在生成JavaDoc文档时，该注解也会出现在javaDoc文档中
public @interface ExecIne {

    public String value() default "";
}

