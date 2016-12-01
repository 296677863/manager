package org.manager.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by lei on 12/1/2016.
 */
public abstract class AbstractJdbcRepository {
    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
