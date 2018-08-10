package com.mostafa.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminHome {
    @RequestMapping("/a")
    public String welcome(){
        return "admin_home";
    }
}
