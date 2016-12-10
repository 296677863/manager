package org.manager.dao;

/**
 * Created by lei on 2016/12/10.
 */
public interface SQLPageHandle {
    public String handlerPagingSQL(String oldSql, int pageNo, int pageSize);
}
