package com.even.controller;

import com.even.service.ISysAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by even on 2017/12/21.
 */
@Controller
@RequestMapping("/sysAuth")
public class SysAuthController {
    @Resource
    private ISysAuthService sysAuthService;

}
