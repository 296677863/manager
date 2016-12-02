package com.lei.web;

import com.lei.Dto.LoginDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
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


    /*
     * Go login page
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute LoginDto loginDto, BindingResult errors) {
        UsernamePasswordToken token=new UsernamePasswordToken(loginDto.getUsername(), loginDto.getPassword());
        token.setRememberMe(false);
        try{
             SecurityUtils.getSubject().login(token);
        }catch (Exception e){
            Log.debug("Error authentication.",e);
            errors.rejectValue("username", null, "The username or password was not correct.");
            return "login";
        }
        return "redirect:index";
    }




}
