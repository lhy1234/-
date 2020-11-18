package com.example.demo.controller;

import com.example.demo.result.AppResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * create by lihaoyang on 2020/8/11
 */
@RestController
@RequestMapping("")
public class SignVerifyController {

    private String secret = "7yuijhyt45de2";

    @PostMapping("verifySign")
    public boolean verifySign(HttpServletRequest request){
        System.out.println("request check 拦截");
        //获取上下文（重要，贯穿 所有filter，包含所有参数）

        Long timestamp = Long.valueOf(request.getHeader("timestamp"));
        String token = request.getHeader("token");
        String sign = request.getHeader("sign");

        String localSign = DigestUtils.sha1Hex(token + timestamp + secret);
        boolean flag = true;
        // 判断时间戳是不是在1分钟以内
        Long now = Calendar.getInstance().getTimeInMillis();
        if(!(flag && (now - timestamp < 60 * 1000))) {
            flag = false;
        }

        if(!(flag && (localSign.trim().equals(sign)))) {
            flag = false;
        }

        return flag;
    }

}
