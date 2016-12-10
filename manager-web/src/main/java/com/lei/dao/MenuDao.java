package com.lei.dao;

import org.manager.model.Permission;

import java.util.List;

/**
 * Created by lei on 2016/12/10.
 */
public interface MenuDao {
    List<Permission> findMenuListByUserName(String username);
}
