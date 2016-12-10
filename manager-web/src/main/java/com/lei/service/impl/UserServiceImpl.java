package com.lei.service.impl;

import com.lei.dao.UserAuthzDao;
import com.lei.service.UserService;
import org.manager.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lei on 2016/12/3.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserAuthzDao userAuthzDao;

    @Override
    public boolean isExistedUsername(String username) {
        final Users user=userAuthzDao.findByUsername(username);
        return user != null;
    }
}
