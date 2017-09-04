package com.java.spring.beans;

import org.springframework.context.event.EventListener;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Component;

/**
 *
 * Created by zhangfeifei2 on 2017/8/3.
 */

@Component
public class EventBean {

    @EventListener(condition = "true")
    public void execEjb(){

    }


    @ReadOnlyProperty
    public int envReadOnly() {
        return super.hashCode();
    }
}
