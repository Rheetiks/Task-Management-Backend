package com.taskmanagement.taskmanagementbackend.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.taskmanagement.taskmanagementbackend.Model.Task;
import com.taskmanagement.taskmanagementbackend.Model.User;

public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {

        Task task = new Task();
        User user = new User();

        task.setTaskId(rs.getInt(1));
        user.setUserId(rs.getInt(2));
        task.setUser(user);
        task.setTitle(rs.getString(3));
        task.setDescription(rs.getString(4));
        task.setDueDate(rs.getDate(5).toString());
        task.setStatus(rs.getString(6));

        return task;

    }
    
}
