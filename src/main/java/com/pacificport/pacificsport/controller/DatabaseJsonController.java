package com.pacificport.pacificsport.controller;

import com.pacificport.pacificsport.service.CutJSONService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class DatabaseJsonController {

    private CutJSONService cutService;

    @Autowired
    public DatabaseJsonController(CutJSONService cutService) {
        this.cutService = cutService;
    }
    @GetMapping("/cuts")
    public String findAll(){
        return cutService.findAll();
    }
}
