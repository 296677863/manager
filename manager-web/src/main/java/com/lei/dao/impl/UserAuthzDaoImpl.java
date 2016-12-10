package com.lei.dao.impl;

import com.lei.dao.UserAuthzDao;
import org.apache.commons.lang.StringUtils;
import org.manager.dao.BaseDao;
import org.manager.dao.Impl.BaseDaoImpl;
import org.manager.jdbc.AbstractJdbcRepository;
import org.manager.mapper.PermissionRowMapper;
import org.manager.mapper.RolesRowMapper;
import org.manager.mapper.UsersRowMapper;
import org.manager.model.Permission;
import org.manager.model.Roles;
import org.manager.model.Users;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by lei on 2016/12/3.
 */
@Repository("userAuthzDao")
public class UserAuthzDaoImpl extends BaseDaoImpl implements UserAuthzDao{

    private static UsersRowMapper usersRowMapper = new UsersRowMapper();
    private static RolesRowMapper rolesRowMapper = new RolesRowMapper();
    private static PermissionRowMapper permissionRowMapper=new PermissionRowMapper();

    @Override
    public List<Roles> findUsersRolesList(String usersGuid) {
        String sql = " select r.* from roles r where r.archived = 0 and r.id in (" +
                " select roles_id from user_roles where users_id = (" +
                " select id from users where guid = ? and archived = 0))";
        return this.jdbcTemplate.query(sql, rolesRowMapper, usersGuid);
    }

    @Override
    public List<Users> findUsersByUsername(String username) {
        String sql = " select u.* from users u where u.archived = 0 ";
        if (StringUtils.isNotEmpty(username)) {
            sql += " and u.username = ?  order by u.id desc ";
//            this.find(sql,new String[]{username},UsersRowMapper.class);
            return this.jdbcTemplate.query(sql, usersRowMapper, username);

        }
        sql += " order by u.id desc ";
//        this.find(sql,null);
        return this.jdbcTemplate.query(sql, usersRowMapper);
    }

    @Override
    public List<Permission> findPermissionsByRoles(String rolesGuid) {

        String sql = "select p.* from permission p where p.id in ("+
                " select rp.permission_id from roles_permissions rp where p.roles_id = (" +
                " select id from roles where guid = ? and archived = 0 )";
        return this.jdbcTemplate.query(sql, permissionRowMapper, rolesGuid);
    }

    @Override
    public List<Roles> findRolesByPermission(String permissionGuid) {
       return null;
    }

    @Override
    public List<Roles> findAvailableRolesList() {
        String sql = " select r.* from roles r where r.archived = 0 ";
        return this.jdbcTemplate.query(sql, rolesRowMapper);
    }

    @Override
    public Users findByUsername(String username) {
        String sql = " select * from users where username = ? ";
        final List<Users> list = this.jdbcTemplate.query(sql, usersRowMapper, username);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int saveUsers(final Users users) {
        String sql = " insert into users(guid,create_time, username,password) values (?,?,?,?) ";
        this.jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, users.guid());
                ps.setTimestamp(2, new Timestamp(users.createTime().getTime()));
                ps.setString(3, users.username());

                ps.setString(4, users.password());
            }
        });

        return this.jdbcTemplate.queryForObject("select id from users where guid = ?", new Object[]{users.guid()}, Integer.class);
    }

    @Override
    public Roles findRolesByGuid(String guid) {
        final List<Roles> list = this.jdbcTemplate.query(" select * from roles where guid = ?", rolesRowMapper, guid);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void insertUserRoles(final int userId, final int rolesId) {
        String sql = "insert into user_roles(users_id,roles_id) values (?,?) ";
        this.jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, userId);
                ps.setInt(2, rolesId);
            }
        });

    }
}
