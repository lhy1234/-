package com.example.demo.service;

import com.example.demo.event.MailSendEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * create by lihaoyang on 2020/8/11
 */
@Component
public class MailSender implements ApplicationContextAware {

    private ApplicationContext ctx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = ctx;
    }

    public void sendMail(String to){
        System.err.println("MailSender 模拟发送邮件。。。");
        MailSendEvent mailSendEvent = new MailSendEvent(this.ctx,to);
        ctx.publishEvent(mailSendEvent);
    }
}
