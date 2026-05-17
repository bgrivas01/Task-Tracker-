package com.example.Task_Tracker_CLI;

import java.io.IOException;

import org.springframework.shell.core.command.annotation.Argument;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

@Component
public class myCommands {
    TaskRepository taskRepository = new TaskRepository();



    @Command(name = "add", description = "Add a new task")
    public String addTask(@Argument(index = 0) String description) throws StreamWriteException, DatabindException, IOException{
        taskRepository.addTask(description);
        // Logic to add a new task
        return "Task added successfully: (ID:{1} )";
}
    
}
