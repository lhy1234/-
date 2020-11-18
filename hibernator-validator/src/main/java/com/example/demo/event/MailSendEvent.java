package com.example.demo.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * create by lihaoyang on 2020/8/11
 */
public class MailSendEvent extends ApplicationContextEvent {

    //发送目的地
    private String sendTo;

    public MailSendEvent(ApplicationContext source,String sendTo) {
        super(source);
        this.sendTo = sendTo;
    }

    public String getSendToTo() {
        return sendTo;
    }


}
