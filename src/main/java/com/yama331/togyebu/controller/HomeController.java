package com.yama331.togyebu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Main page method
    @GetMapping("/main")
    public String mainIndex() {

        return "main";

    }
}
