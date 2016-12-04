package com.lei.service.impl;

import com.lei.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by lei on 2016/12/3.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Override
    public boolean isExistedUsername(String username) {
        return false;
    }
}
