package com.example.marketplace.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class MainController {
    @RequestMapping("market/main")
    public ModelAndView getAll(){
        return new ModelAndView("index");
    }

    @RequestMapping("market/settings")
    public ModelAndView get(){
        return new ModelAndView("settings");
    }


    @RequestMapping("market/delivery")
    public ModelAndView getDelivery(){
        return new ModelAndView("delivery");
    }

    @RequestMapping("market/store")
    public ModelAndView getStore(){
        return new ModelAndView("store");
    }
    @RequestMapping("market/return")
    public ModelAndView getReturn(){
        return new ModelAndView("return");
    }

    @RequestMapping("market/sell")
    public ModelAndView getSell(){
        return new ModelAndView("sell");
    }

    @RequestMapping("market/warehouse")
    public ModelAndView getWarehouse(){
        return new ModelAndView("warehouse");
    }



}
