package com.kavin.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    @Reference(check = false)  //引用远程暴露的服务
    private UserService userService;

    @HystrixCommand(fallbackMethod = "isError") //
    public String getMsg() {
        return userService.sayHello("张三");
    }

    public String isError(){
        return "The request is Error";
    }

}
