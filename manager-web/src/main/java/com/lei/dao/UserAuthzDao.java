package com.lei.dao;

import org.manager.dao.UsersDao;
import org.manager.model.Roles;
import org.manager.model.Users;

import java.util.List;

/**
 * Created by lei on 2016/12/3.
 */
public interface UserAuthzDao extends UsersDao{
    List<Users> findUsersByUsername(String username);

    List<Roles> findAvailableRolesList();

    Users findByUsername(String username);

    int saveUsers(Users users);

    Roles findRolesByGuid(String guid);

    void insertUserRoles(int userId, int rolesId);
}
