package com.even.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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

    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void test(){
        Subject subject= SecurityUtils.getSubject();
        PrincipalCollection principals = subject.getPrincipals();
        for (Object principal : principals) {
            System.out.println("obj:==="+principal);
        }
    }
}
