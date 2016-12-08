package org.manager.model;

import org.manager.dao.UsersDao;
import org.manager.util.BeanProvider;

import java.util.List;

/**
 * Created by lei on 12/8/2016.
 */
public class Permission extends AbstractDomain {
    private transient UsersDao usersRepository = BeanProvider.getBean(UsersDao.class);

    private int id;

    private String code;//权限代码

    private String menuName;

    private String menuUrl;

    private String parentId;

    public Integer sort;

    public Permission() {
    }

    public List<Roles> roles() {
        return this.usersRepository.findRolesByPermission(this.guid);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public Permission setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMenuName() {
        return menuName;
    }

    public Permission setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public Permission setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Permission setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public Permission setSort(Integer sort) {
        this.sort = sort;
        return this;
    }
}
