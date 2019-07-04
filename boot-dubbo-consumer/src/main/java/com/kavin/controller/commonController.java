package com.kavin.controller;

import com.kavin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class commonController {

    @Autowired
    private LoginService loginService;


    @ResponseBody
    @RequestMapping("/")
    public String getUser() {
        return loginService.getMsg();
    }
}
