package com.design.mode.factory.common;

/**
 * Created by zhangfeifei on 2016/12/08.
 */


public class MailSender implements ISender {
    public void send() {
        System.out.println("This is Big Window !");
    }
}