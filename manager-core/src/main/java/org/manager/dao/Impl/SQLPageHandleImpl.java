package org.manager.dao.Impl;

import org.manager.dao.SQLPageHandle;
import org.springframework.stereotype.Repository;

/**
 * Created by lei on 2016/12/10.
 */
@Repository("sqlPageHandle")
public class SQLPageHandleImpl implements SQLPageHandle {
    @Override
    public String handlerPagingSQL(String oldSql, int pageNo, int pageSize) {
            StringBuffer sql = new StringBuffer(oldSql);
            if (pageSize > 0) {
                int firstResult = (pageNo - 1)*pageSize;
                if (firstResult <= 0) {
                    sql.append(" limit ").append(pageSize);
                } else {
                    sql.append(" limit ").append(firstResult).append(",")
                            .append(pageSize);
                }
            }
            return sql.toString();
    }
}
