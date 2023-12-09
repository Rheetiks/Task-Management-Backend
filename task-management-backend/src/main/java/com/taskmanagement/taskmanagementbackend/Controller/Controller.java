package com.taskmanagement.taskmanagementbackend.Controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.taskmanagement.taskmanagementbackend.Model.Task;
import com.taskmanagement.taskmanagementbackend.Service.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RequestMapping("/user")
@RestController
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/getTask")
    public List<Task> getTasks(@RequestHeader("Authorization") String authorization) {
        String jwtToken = authorization.replace("Bearer ", "");
        return service.getTasks(jwtToken);

    }

    

    @PostMapping("/createTask")
    public String createTask(@RequestHeader("Authorization") String authorization,@RequestBody Task task) throws DataAccessException, ParseException {
        String jwtToken = authorization.replace("Bearer ", "");
        return this.service.createTask(jwtToken, task);
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable int id,@RequestHeader("Authorization") String authorization) {
        String jwtToken = authorization.replace("Bearer ", "");
        return this.service.deteleTask(id,jwtToken);
    }

    @PostMapping("/updateTask/{id}")
    public String updateTask(@PathVariable int id,@RequestBody String status,@RequestHeader("Authorization") String authorization) {
        String jwtToken = authorization.replace("Bearer ", "");
        return this.service.updateTask(id,status,jwtToken);
    }

    @GetMapping("/getTask/{id}")
    public List<Task> getTaskById(@PathVariable int id) {
        return service.getTaskById(id);

    }
    
    
    
}
