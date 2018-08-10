package com.mostafa.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherHomeController {

    @RequestMapping("/t")
    public String welcome() {
        return "teacher_home";
    }
}
