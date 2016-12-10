package com.lei.dao.impl;

import com.lei.dao.MenuDao;
import com.lei.view.MenuDto;
import org.manager.dao.Impl.BaseDaoImpl;
import org.manager.mapper.PermissionRowMapper;
import org.manager.model.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lei on 2016/12/10.
 */
@Repository
public class MenuDaoImpl extends BaseDaoImpl implements MenuDao{
    private static final Logger logger= LoggerFactory.getLogger(MenuDaoImpl.class);
    private static PermissionRowMapper permissionRowMapper=new PermissionRowMapper();

    @Override
    public List<Permission> findMenuListByUserName(String userName) {

        String sql="select p.* FROM roles_permissions AS rp\n" +
                "INNER JOIN roles AS r ON rp.roles_id=r.id\n" +
                "inner JOIN user_roles as ur  ON rp.roles_id=ur.roles_id\n" +
                "INNER JOIN users AS u ON u.id=ur.users_id\n" +
                "INNER JOIN permission AS p  ON rp.permission_id=p.id\n" +
                "where u.username=?";
        logger.info(sql+":"+userName);
        return  this.jdbcTemplate.query(sql, permissionRowMapper,new String[]{userName});
    }
}
