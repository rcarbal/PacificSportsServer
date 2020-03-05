package com.pacificport.pacificsport.controller;

import com.pacificport.pacificsport.service.cut.CutJSONService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/json")
public class DatabaseJsonController {

    private CutJSONService cutService;

    @Autowired
    public DatabaseJsonController(CutJSONService cutService) {
        this.cutService = cutService;
    }

    @GetMapping("/cuts")
    public JSONObject findAll(){
        return cutService.findAll();
    }
}
