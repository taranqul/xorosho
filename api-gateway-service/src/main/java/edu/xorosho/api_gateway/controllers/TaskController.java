package edu.xorosho.api_gateway.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.xorosho.api_gateway.domains.tasks.dto.TaskRequest;
import edu.xorosho.api_gateway.domains.tasks.dto.TaskResponse;
import edu.xorosho.api_gateway.domains.tasks.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Tag(name="Task-related endpoints")
@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/")
    public TaskResponse postTask(@RequestBody TaskRequest request) {
        return taskService.createTask(request);
    }
    
    @GetMapping("/{task}/schema")
    public String getTaskSchemas(@PathVariable String task) {
        return new String();
    }
    
    @GetMapping("/")
    public List<String> getTasks() {
    return Arrays.asList("unimlemented");
}
    
}
