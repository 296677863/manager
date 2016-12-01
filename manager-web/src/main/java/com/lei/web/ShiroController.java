package com.lei.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lei on 12/1/2016.
 */
@Controller
public class ShiroController {

    private static final Logger Log= LoggerFactory.getLogger(ShiroController.class);

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }


    /*
     * Go login page
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {

        return "login";
    }




}
