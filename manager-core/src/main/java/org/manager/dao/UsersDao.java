package org.manager.dao;

import org.manager.model.Permission;
import org.manager.model.Roles;

import java.util.List;

/**
 * Created by lei on 12/1/2016.
 */
public interface UsersDao extends BaseDao{

    List<Roles> findUsersRolesList(String usersGuid);

    List<Permission> findPermissionsByRoles(String rolesGuid);

    List<Roles> findRolesByPermission(String permissionGuid);
}
