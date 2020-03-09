package com.pacificport.pacificsport.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String echo(){
        return "Echo request";
    }
}
