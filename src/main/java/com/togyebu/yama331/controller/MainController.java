package com.togyebu.yama331.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 메인 페이지 관련 컨트롤러 (Tgb003)
 */

@Controller
public class MainController {

    /**
     * 메인 페이지로 이동
     * @return main/index.html
     */
    @GetMapping("/main")
    public String main() {

        return "main/index";

    }
    
}
