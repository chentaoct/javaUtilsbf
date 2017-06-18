package com.shanghai.controller.mvcController;

import com.shanghai.domain.Person;
import com.shanghai.domain.UserDomain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 陈涛 on 2017/6/14.
 */
@Controller
@RequestMapping("testParams")
public class TestParams {
    @RequestMapping(value = "testRequestBody", method = RequestMethod.POST)
    @ResponseBody
    public Person  testRequestBody(@RequestBody Person person){
        return person;
    }
    @RequestMapping(value = "testRequestBody2", method = RequestMethod.POST)
    @ResponseBody
    public UserDomain  testRequestBody2(@RequestBody UserDomain userDomain){
        return userDomain;
    }
}
