package com.even.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by even on 2017/12/5.
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }

}
