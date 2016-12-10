package org.manager.mapper;

import org.manager.model.Permission;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lei on 2016/12/10.
 */
public class PermissionRowMapper implements RowMapper<Permission> {
    @Override
    public Permission mapRow(ResultSet resultSet, int i) throws SQLException {
        Permission permission=new Permission();
        permission.setId(resultSet.getInt("id"));
        permission.setCode(resultSet.getString("code"));
        permission.setMenuName(resultSet.getString("menuName"));
        permission.setMenuUrl(resultSet.getString("menuUrl"));
        permission.setParentId(resultSet.getString("parentId"));
        permission.guid(resultSet.getString("guid"))
                .createTime(resultSet.getTimestamp("create_time"));
        return permission;
    }
}
