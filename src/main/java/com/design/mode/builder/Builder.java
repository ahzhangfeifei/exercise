package com.design.mode.builder;

import com.design.mode.factory.common.ISender;
import com.design.mode.factory.common.MailSender;
import com.design.mode.factory.common.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Builder.
 * Created by zhangfeifei on 2016/12/05.
 */
public class Builder {
	private List<ISender> list = new ArrayList<ISender>();

    /**
     * Produce mail sender.
     *
     * @param count the count
     */
    public void produceMailSender(int count){
        for(int i=0; i<count; i++){  
            list.add(new MailSender());  
        }  
    }

    /**
     * Produce sms sender.
     *
     * @param count the count
     */
    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){  
            list.add(new SmsSender());  
        }  
    }  
}
