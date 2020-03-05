package com.pacificport.pacificsport.controller;

import com.pacificport.pacificsport.service.cut.CutJSONService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Locale;

@Controller
public class OrderController {

    @Autowired
    private CutJSONService cutService;

    public OrderController() {
    }

    @PostConstruct
    private void initiate(){
        System.out.println("==============>>>>> running initiate() for " + getClass());
    }

    @RequestMapping("/orderform")
    public String getOrderForm(Model theModel){
        JSONObject cuts = cutService.findAll();

        theModel.addAttribute("theCuts", cuts);
        theModel.addAttribute("theDate", new Date());
        return "orderform";
    }

}
