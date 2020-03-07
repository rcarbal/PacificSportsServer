package com.pacificport.pacificsport.controller;

import com.pacificport.pacificsport.bean.Cut;
import com.pacificport.pacificsport.service.cut.CutJSONService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

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

        // Create model to bind form data
        Cut theCut = new Cut();

        theModel.addAttribute("cut", theCut);

        return "order/orderform";
    }

    @RequestMapping("/order/save")
    public void saveOrder(){

        System.out.println();
    }

}
