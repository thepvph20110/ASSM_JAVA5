package com.ASSM.thepv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author thepvph20110
 */

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
