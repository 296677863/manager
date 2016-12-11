package com.lei.service.impl;

import com.lei.dao.MenuDao;
import com.lei.service.MenuService;
import com.lei.view.MenuDto;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.manager.model.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lei on 2016/12/9.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService{
    private static final Logger logger= LoggerFactory.getLogger(MenuServiceImpl.class);
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<MenuDto> findMenuList() {
        Subject subject = SecurityUtils.getSubject();
        String userName=(String) subject.getPrincipal();
        List<Permission> permissions=menuDao.findMenuListByUserName(userName);
        List<MenuDto> parentList=new ArrayList<MenuDto>();
        for(Permission p:permissions){
            String guid=p.guid();
            String parentId=p.getParentId();
            if(StringUtils.isEmpty(parentId)){
                MenuDto menuDto=new MenuDto();
                menuDto.setId(guid);
                menuDto.setName(p.getMenuName());
                menuDto.setUrl(p.getMenuUrl());
                String cls=p.getIconUrl();
                menuDto.setIconCls(cls);
                List<MenuDto> childList=new ArrayList<MenuDto>();
                for(Permission cp:permissions){
                    MenuDto menuChildDto=new MenuDto();
                    String sid=cp.getParentId();
                    if(!StringUtils.isEmpty(sid)){
                        if(sid.equals(guid)){
                            menuChildDto.setId(cp.guid());
                            menuChildDto.setPid(cp.guid());
                            menuChildDto.setName(cp.getMenuName());
                            menuChildDto.setUrl(cp.getMenuUrl());
                            childList.add(menuChildDto);
                        }
                    }
                }
                menuDto.setChild(childList);
                parentList.add(menuDto);
            }
        }
        return parentList;
    }
}
