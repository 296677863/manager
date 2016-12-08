package org.manager.model;

import org.manager.dao.UsersDao;
import org.manager.util.BeanProvider;

import java.util.List;

/**
 * Created by Administrator on 12/1/2016.
 */
public class Roles  extends AbstractDomain {

    private static final long serialVersionUID = 8762398291767207066L;


    private transient UsersDao usersRepository = BeanProvider.getBean(UsersDao.class);

    private int id;

    private String roleName;

    public Roles() {
    }

    public int id() {
        return id;
    }

    public Roles id(int id) {
        this.id = id;
        return this;
    }

    public List<Permission> permissions() {
        return this.usersRepository.findPermissionsByRoles(this.guid);
    }

    public String roleName() {
        return roleName;
    }

    public Roles roleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
}
