package com.taskmanagement.taskmanagementbackend.Dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.taskmanagement.taskmanagementbackend.Config.JwtUtil;
import com.taskmanagement.taskmanagementbackend.Model.JwtRequest;
import com.taskmanagement.taskmanagementbackend.Model.Task;
import com.taskmanagement.taskmanagementbackend.Model.User;
import com.taskmanagement.taskmanagementbackend.RowMapper.TaskRowMapper;
import com.taskmanagement.taskmanagementbackend.RowMapper.UserRowMapper;

@Repository
public class Dao {

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private JwtUtil helper;

    public JwtRequest getUserByEmail(String Email){
        String sql="select * from user where userEmail=?";
        User user=this.jdbc.queryForObject(sql, new UserRowMapper(),Email );
        JwtRequest request= new JwtRequest();
        request.setUserEmail(Email);
        request.setUserRole(user.getUserRole());
        request.setUserPassword(user.getUserPassword());
        return request;
    }

    public String createTask(String jwtToken,Task task) throws DataAccessException, ParseException{
        String sql="insert into Task (userId,title,Description,DueDate,Status) values((select userId from user where userEmail=?),?,?,?,?)";
        this.jdbc.update(sql, helper.getUsernameFromToken(jwtToken),task.getTitle(),task.getDescription(),new SimpleDateFormat("yyyy-MM-dd").parse(task.getDueDate()),task.getStatus() );
        return "Successfully Inserted Your Task";

    }

    public List<Task> getTasks(String jwtToken){
        String sql="select * from Task where userId=(select userId from user where userEmail=?)";
        return this.jdbc.query(sql,new TaskRowMapper(),helper.getUsernameFromToken(jwtToken));
    }

    public String deleteTaskById(int id){
        String sql="delete from task where taskId=?";
        this.jdbc.update(sql,id);
        return "Successfully deleted the Task";
    }

    public String updateTask(int id,String status){
        String sql="update Task set status=? where taskId=?";
        this.jdbc.update(sql,status, id);
        return "Successfully updated the Task";
    }


    
}
