package com.example.janken.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JankenController {
    @RequestMapping("/hello")
    public String index() {
        return "hello";
    }
}
