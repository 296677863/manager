package org.manager.model;

import org.manager.dao.UsersDao;
import org.manager.util.BeanProvider;

import java.util.Date;
import java.util.List;

/**
 * Created by lei on 12/1/2016.
 */
public class Users extends AbstractDomain{
    private static final long serialVersionUID = -3990278799194556012L;

    private transient UsersDao usersRepository = BeanProvider.getBean(UsersDao.class);

    private String username;
    private String password;


    private boolean defaultUser;
    private Date lastLoginTime;

    public Users(){};

    public List<Roles> rolesList() {
        return usersRepository.findUsersRolesList(this.guid);
    }


    public String username() {
        return username;
    }

    public Users username(String username) {
        this.username = username;
        return this;
    }

    public String password() {
        return password;
    }

    public Users password(String password) {
        this.password = password;
        return this;
    }

    public boolean defaultUser() {
        return defaultUser;
    }

    public Users defaultUser(boolean defaultUser) {
        this.defaultUser = defaultUser;
        return this;
    }

    public Date lastLoginTime() {
        return lastLoginTime;
    }

    public Users lastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }


}
