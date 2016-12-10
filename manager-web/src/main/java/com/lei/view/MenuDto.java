package com.lei.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/9.
 */
public class MenuDto {
    private String id;
    private String pid;
    private String name;
    private String iconCls;
    private String url;
    private List<MenuDto> child=new ArrayList<MenuDto>();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIconCls() {
        return iconCls;
    }
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public List<MenuDto> getChild() {
        return child;
    }
    public void setChild(List<MenuDto> child) {
        this.child = child;
    }
}
