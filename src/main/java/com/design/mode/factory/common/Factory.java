package com.design.mode.factory.common;

/**
 * 普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 * Created by zhangfeifei on 2016/12/08.
 */

public class Factory {

    /**
     * Create sender sender.
     *
     * @param type the type
     * @return the sender
     */
    public ISender createSender (String type) {
        if(type.equals("sms")) {
            return new SmsSender();
        } else if(type.equals("email")) {
            return new MailSender();
        } else {
            return new SmsSender();
        }
    }
}