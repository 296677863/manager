package org.manager.dao.Impl;

import org.manager.dao.BaseDao;
import org.manager.dao.SQLPageHandle;
import org.manager.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by lei on 2016/12/10.
 */
@Repository
public class BaseDaoImpl implements BaseDao {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Resource(name="sqlPageHandle")
    protected SQLPageHandle sqlPageHandle;

    public <T> List<T> find(String sql, Object[] params, Class<T> tClass) {
        List<T> resultList = null;
        try {
            if (params != null && params.length > 0)
                resultList = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<T>(tClass));
            else
                // BeanPropertyRowMapper是自动映射实体类的
                resultList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(tClass));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public <T> int addOrUpdateOrDelete(String sql, final Object[] params, Class<T> tClass) {
        int num = 0;
        try {
            if (params == null || params.length == 0)
                num = jdbcTemplate.update(sql);
            else
                num = jdbcTemplate.update(sql, new PreparedStatementSetter() {
                    public void setValues(PreparedStatement ps) throws SQLException {
                        for (int i = 0; i < params.length; i++)
                            ps.setObject(i + 1, params[i]);
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
            num = -1;
        }
        return num;

    }

    /**
     * @param sql
     * @param parameters
     * @param pageNo
     * @param pageSize
     * @param entity     jdbcTemplate.query由于需要返回自定义对象，调用此方法时候需要传入new BeanPropertyRowMapper<T>(entity)
     * @param <T>
     * @return
     */
    public <T> Page<T> queryPagination(String sql, Object[] parameters, int pageNo, int pageSize, Class<T> entity) {
        // 将SQL语句进行分页处理
        String newSql = sqlPageHandle.handlerPagingSQL(sql, pageNo, pageSize);
        List<T> list = null;
        List<T> totalList = null;
        if (parameters == null || parameters.length <= 0) {
            totalList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(entity));
            list = jdbcTemplate.query(newSql, new BeanPropertyRowMapper<T>(entity));
        } else {
            totalList = jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper<T>(entity));
            list = jdbcTemplate.query(newSql, parameters, new BeanPropertyRowMapper<T>(entity));
        }
        // 根据参数的个数进行差别查询
        Page<T> page = new Page<T>(pageNo, pageSize, totalList.isEmpty() ? 0 : totalList.size(), list);

        return page;
    }

    /**
     * @param sql
     * @param args
     * @param classT 注意该参数，jdbcTemplate.queryForObject传入的不能是自定义的classType，
     *               如果是自定义的，需要经过new BeanPropertyRowMapper<T>(classT)转换，默认支持的只有比如String，int等类型
     * @param <T>
     * @return
     */
    public <T> T findForObject(String sql, Object[] args, Class<T> classT) {
        if (sql == null || sql.length() <= 0) {
            return null;
        }
        if (args == null || args.length <= 0) {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<T>(classT));
        }
        return jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<T>(classT));
    }

    public Map<String, Object> find(String sql, Object[] params) {
        return jdbcTemplate.queryForMap(sql,params);
    }

    public List<Map<String, Object>> queryList(String sql, Object[] params) {
        return jdbcTemplate.queryForList(sql,params);
    }
}
