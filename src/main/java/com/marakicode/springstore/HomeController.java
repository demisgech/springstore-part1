package com.marakicode.springstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/home")
    public String  home() {
        return "index.html";
    }
}
