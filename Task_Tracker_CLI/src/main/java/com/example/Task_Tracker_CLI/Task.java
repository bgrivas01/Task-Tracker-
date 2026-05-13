package com.example.Task_Tracker_CLI;

import java.time.LocalDateTime;

public class Task {
    private Integer id;
    private String description;
    private enum Status {
        NOT_STARTED,
        IN_PROGRESS,
        DONE
    }
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(Integer id, String description, Status status) { //we are going to set status to NOT_STARTED by default somehow
        this.id = id;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    //getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
   
}
