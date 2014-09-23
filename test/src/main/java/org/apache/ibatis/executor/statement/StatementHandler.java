package org.apache.ibatis.executor.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;

/**
 * 主要的更改在于，可以直接获取MappedStatement。
 * 
 * @author Clinton Begin
 * @author 尹雷
 */
public interface StatementHandler {

    Statement prepare(Connection connection) throws SQLException;

    void parameterize(Statement statement) throws SQLException;

    void batch(Statement statement) throws SQLException;

    int update(Statement statement) throws SQLException;

    <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException;

    BoundSql getBoundSql();

    ParameterHandler getParameterHandler();

    /**
     * 获得MappedStatement
     * @return MappedStatement
     * @author yinlei
     */
    MappedStatement getMappedStatement();//yinlei

}
