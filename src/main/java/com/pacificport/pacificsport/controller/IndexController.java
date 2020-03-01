package com.pacificport.pacificsport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    String home() {
        return "Welcome Screen Route";
    }
}
