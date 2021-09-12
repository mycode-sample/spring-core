package com.sheepfly.springcore.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServiceController {
    @RequestMapping("hello.go")
    public String service() {
        return "hello,spring.";
    }
}
