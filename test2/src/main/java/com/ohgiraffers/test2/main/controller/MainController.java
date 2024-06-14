package com.ohgiraffers.test2.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/","/car"})
    public String main(){
        return "main/main";
    }
}
