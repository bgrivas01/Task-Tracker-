package com.example.Task_Tracker_CLI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Jackson is what we need for ObjectMapper in order top map out objects in the JSON format
import com.fasterxml.jackson.core.exc.StreamWriteException;   
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TaskRepository {
    ObjectMapper objectMapper = new ObjectMapper()
        .registerModule(new JavaTimeModule());


    File file = new File("tasks.json");  //this doesn't actually create the tasks.json file
    List<Task> tasks; //List of tasks that we will be adding to the JSON file in the JSON format using objectMapper

    
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
            objectMapper.writeValue(file, tasks); //this is what also creates our json file if it doesnt exist
        
    }
    //this will allow me to get a certain task by id
    public String getTask(Int id){
        return //i will return a string, specifically the description 
    }

    //this will alow me to delete a certain taks by using its id
    public void deleteTask(Int id){
        

    }
}

  

//problem 1: writeValue overwrites the file instead of appending to it, we need to read the file first, add the new task to the list and then write it back to the file
