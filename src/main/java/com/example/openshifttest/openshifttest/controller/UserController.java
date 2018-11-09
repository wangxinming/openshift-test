package com.example.openshifttest.openshifttest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/home"})
public class UserController {
    @RequestMapping(value = "/demo",method = {RequestMethod.GET},produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object demo(HttpServletRequest request){
        return "hello world";
    }
}
