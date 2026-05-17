package com.example.Task_Tracker_CLI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TaskRepository {
    ObjectMapper objectMapper = new ObjectMapper()
        .registerModule(new JavaTimeModule());


    File file = new File("tasks.json");
    List<Task> tasks;

    
    public void addTask(String description) throws StreamWriteException, DatabindException, IOException{

        Task task = new Task(1, description);
        if (file.exists() && file.length() > 0) {
            tasks = objectMapper.readValue(file, new TypeReference<List<Task>>() {});
        } else {
            tasks = new ArrayList<>();
        }
            // 2. Add the new task
            tasks.add(task);
            // 3. Write the entire list back
            objectMapper.writeValue(file, tasks);
        
    }
}

  

//problem 1: writeValue overwrites the file instead of appending to it, we need to read the file first, add the new task to the list and then write it back to the file