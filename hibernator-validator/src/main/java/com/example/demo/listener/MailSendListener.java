package com.example.demo.listener;

import com.example.demo.event.MailSendEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * create by lihaoyang on 2020/8/11
 */
@Component
public class MailSendListener implements ApplicationListener<MailSendEvent> {

    //对mailSend事件进行处理
    @Override
    public void onApplicationEvent(MailSendEvent event) {
        System.err.println("MailSendListener: 向-"+event.getSendToTo() +" 发送一封邮件");
    }
}
