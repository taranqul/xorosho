package edu.xorosho.api_gateway.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.xorosho.api_gateway.domains.tasks.dto.TaskRequest;
import edu.xorosho.api_gateway.domains.tasks.dto.TaskResponse;
import edu.xorosho.api_gateway.domains.tasks.dto.TaskSchemaResponse;
import edu.xorosho.api_gateway.domains.tasks.service.TaskSchemeValidator;
import edu.xorosho.api_gateway.domains.tasks.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Tag(name="Task-related endpoints")
@RestController
@AllArgsConstructor
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;
    private final TaskSchemeValidator taskSchemeValidator;


    @PostMapping("/")
    public TaskResponse postTask(@RequestBody TaskRequest request) {
        taskSchemeValidator.validateScheme(request);
        return taskService.createTask(request);
    }
    
    @GetMapping("/{task}/schema")
    public TaskSchemaResponse getTaskSchemas(@PathVariable String task) {
        return new TaskSchemaResponse(taskSchemeValidator.getTaskSchema(task).getSchema());
    }
    
    @GetMapping("/")
    public List<String> getTasks() {
        return taskSchemeValidator.getTasks();
    }
    
}
