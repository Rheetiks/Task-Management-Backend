package com.taskmanagement.taskmanagementbackend.Model;


public class Task {

    private int taskId;
    private User user;
    private String title;
    private String description;
    private String DueDate;
    private String status;


    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDueDate() {
        return DueDate;
    }
    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    
    
}
