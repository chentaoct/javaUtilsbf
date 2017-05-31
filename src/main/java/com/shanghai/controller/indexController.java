package com.shanghai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 陈涛 on 2017/5/31.
 */
@Controller
@RequestMapping("index")
public class indexController {
    @RequestMapping("toIndex")
    public String  index(HttpServletRequest request, Model model){
        return "index";
    }
}
