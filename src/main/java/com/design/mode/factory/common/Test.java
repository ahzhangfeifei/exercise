package com.design.mode.factory.common;

/**
 * 普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 *
 * Created by zhangfeifei on 2016/12/08.
 */
public class Test {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Factory myFactory = new Factory();
        ISender smSender = myFactory.createSender("sms");
        smSender.send();

        ISender emailSender = myFactory.createSender("email");
        emailSender.send();
    }
}
