package org.manager.model;

import com.lei.util.BeanProvider;
import org.manager.Repository.impl.UsersRepository;

import java.util.List;

/**
 * Created by Administrator on 12/1/2016.
 */
public class Roles  extends AbstractDomain {

    private static final long serialVersionUID = 8762398291767207066L;


    private transient UsersRepository usersRepository = BeanProvider.getBean(UsersRepository.class);

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

    public List<String> permissions() {
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
