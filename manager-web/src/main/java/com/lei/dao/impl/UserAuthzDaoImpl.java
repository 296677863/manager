package com.lei.dao.impl;

import com.lei.dao.UserAuthzDao;
import org.manager.jdbc.AbstractJdbcRepository;
import org.manager.model.Roles;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lei on 2016/12/3.
 */
@Repository("userAuthzDao")
public class UserAuthzDaoImpl extends AbstractJdbcRepository implements UserAuthzDao{
    @Override
    public List<Roles> findUsersRolesList(String usersGuid) {
        return null;
    }

    @Override
    public List<String> findPermissionsByRoles(String rolesGuid) {
        return null;
    }
}
