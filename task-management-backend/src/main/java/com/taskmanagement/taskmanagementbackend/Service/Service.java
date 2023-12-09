package com.taskmanagement.taskmanagementbackend.Service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.taskmanagement.taskmanagementbackend.Dao.Dao;
import com.taskmanagement.taskmanagementbackend.Model.JwtRequest;
import com.taskmanagement.taskmanagementbackend.Model.Task;

@org.springframework.stereotype.Service
public class Service  implements UserDetailsService{

    @Autowired
    private Dao dao;

    public JwtRequest getUserByEmail(String Email){
        return this.dao.getUserByEmail(Email);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        JwtRequest request= getUserByEmail(Email);
        return org.springframework.security.core.userdetails.User
                    .withUsername(request.getUserEmail())
                    .password(passwordEncoder().encode(request.getUserPassword())) 
                    .roles(request.getUserRole())
                    .build();
    }


    public List<Task> getTasks(String jwtToken){
        return this.dao.getTasks(jwtToken);
    }
    
    public String createTask(String jwtToken, Task task) throws DataAccessException, ParseException{
        return this.dao.createTask(jwtToken, task);
    }

    public String deteleTask(int id){
        return this.dao.deleteTaskById(id);
    }

    public String updateTask(int id,String status){
        return this.dao.updateTask(id,status);
    }
}
