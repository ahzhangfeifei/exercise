package com.java.annotion;

import java.lang.reflect.Field;

/**
 * 注解器处理类
 * Created by zhangfeifei on 2017/7/28.
 */
public class DealIne {

    /**
     * 注解处理
     * @param classes
     */
    public void execAnn(Class<?> classes) {
        Field[] fields = classes.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ExecIne.class)) {
                ExecIne execIne = field.getAnnotation(ExecIne.class);
                System.out.println("注解值为：" + execIne.value());
            }
        }
    }
}
