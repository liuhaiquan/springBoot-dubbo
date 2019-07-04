package com.kavin.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;


@Service //使用dubbo提供的service注解，注册暴露服务
//@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {

    @HystrixCommand
    @Override
    public String sayHello(String Name) {

        if(Math.random()>0.5) {
            throw new RuntimeException();
        }
        return "Hello,"+ Name;
    }

}
