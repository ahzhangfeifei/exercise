package com.design.mode.factory.common;

/**
 *
 * Created by zhangfeifei on 2016/12/08.
 */


public class SmsSender implements ISender {
    public void send() {
        System.out.println("This is send sms !");
    }
}