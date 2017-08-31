package com.learning.keep.dao.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.util.Date;

/**
 * Created by huangdawei on 2017/8/29.
 */
@MappedJdbcTypes(JdbcType.TIMESTAMP)
@MappedTypes(Date.class)
public class DateTypeHandler extends BaseTypeHandler<Date> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        preparedStatement.setTimestamp(i, new Timestamp(date.getTime()));
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Timestamp timestamp = resultSet.getTimestamp(s);
        return Date.from(timestamp.toInstant());
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Timestamp timestamp = resultSet.getTimestamp(i);
        return Date.from(timestamp.toInstant());
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Timestamp timestamp = callableStatement.getTimestamp(i);
        return Date.from(timestamp.toInstant());
    }
}
