package com.example.demo.typeHandler;

import com.example.demo.pojo.QuestionType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionTypeHandler implements TypeHandler<QuestionType> {

    @Override
    public void setParameter(PreparedStatement ps, int i, QuestionType parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getIndex());
    }

    @Override
    public QuestionType getResult(ResultSet rs, String columnName) throws SQLException {
        int id=rs.getInt(columnName);
        return QuestionType.GetTypeById(id);
    }

    @Override
    public QuestionType getResult(ResultSet rs, int columnIndex) throws SQLException {
        int id=rs.getInt(columnIndex);
        return QuestionType.GetTypeById(id);
    }

    @Override
    public QuestionType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int id=cs.getInt(columnIndex);
        return QuestionType.GetTypeById(id);
    }
}
