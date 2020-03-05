package com.pacificport.pacificsport.controller;

import com.pacificport.pacificsport.service.cut.CutJSONService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Locale;

@RestController
@RequestMapping("/json")
public class DatabaseJsonController {

    @Autowired
    private CutJSONService cutService;
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/cuts")
    public JSONObject findAll(){

        //this message is not used
        String helloMessage = messageSource.getMessage("good.morning.message", null,
                LocaleContextHolder.getLocale());
        return cutService.findAll();
    }

}
