package com.pacificport.pacificsport.controller;

import com.pacificport.pacificsport.service.cut.CutJSONService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;

@Controller
public class OrderController {

    private CutJSONService cutService;

    @Autowired
    public OrderController(CutJSONService cutService) {
        System.out.println("==============>>>>> running @Autowired on constructor for " + getClass());
        this.cutService = cutService;
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
