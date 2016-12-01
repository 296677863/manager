package org.manager.Repository.impl;

import org.manager.Repository.Repository;
import org.manager.model.Roles;

import java.util.List;

/**
 * Created by lei on 12/1/2016.
 */
public interface UsersRepository extends Repository{

    List<Roles> findUsersRolesList(String usersGuid);

    List<String> findPermissionsByRoles(String rolesGuid);
}
