package com.taskmanagement.taskmanagementbackend.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.taskmanagement.taskmanagementbackend.Model.User;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user= new User();
        
        user.setUserId(rs.getInt(1));
        user.setUserName(rs.getString(2));
        user.setUserEmail(rs.getString(3));;
        user.setUserPassword(rs.getString(4));
        user.setUserRole(rs.getString(5));

        return user;

    }
    
}
