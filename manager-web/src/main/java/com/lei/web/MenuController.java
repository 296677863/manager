package com.lei.web;

import com.lei.service.MenuService;
import com.lei.view.MenuDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lei on 2016/12/9.
 */
@Controller
public class MenuController {
    private static final Logger Log= LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @RequestMapping("menuList")
    @ResponseBody
    public List<MenuDto> menuList(){
        return menuService.findMenuList();
    }

}
