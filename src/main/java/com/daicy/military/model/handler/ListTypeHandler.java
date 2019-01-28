package com.daicy.military.model.handler;

import net.sf.json.JSONArray;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@MappedJdbcTypes({JdbcType.VARCHAR})
@MappedTypes({List.class})
public class ListTypeHandler extends BaseTypeHandler {


    private static Logger log = Logger.getLogger(ListTypeHandler.class);

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        try {
            JSONArray json = JSONArray.fromObject(o);
            preparedStatement.setString(i, json.toString());
        } catch (Exception e) {
            log.error("Object to Json String" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String result = resultSet.getString(s);
        List<Object> list = JSONArray.fromObject(result);
        return list;
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString(i);
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i);
    }

}
