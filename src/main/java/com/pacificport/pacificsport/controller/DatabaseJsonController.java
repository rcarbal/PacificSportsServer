package com.pacificport.pacificsport.controller;

import com.pacificport.pacificsport.service.cut.CutJSONService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/json")
public class DatabaseJsonController {

    @Autowired
    private CutJSONService cutService;
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/cuts")
    public Map<String, JSONObject> findAll(){
        return cutService.findAll();
    }

    @GetMapping("cuts/{number}")
    public JSONObject getCutNumber(@PathVariable String number){
        JSONObject cutObject = cutService.getCutNumber(number);
        return cutObject;
    }

}
