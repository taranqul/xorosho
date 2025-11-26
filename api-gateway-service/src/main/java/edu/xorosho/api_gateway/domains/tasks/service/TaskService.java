package edu.xorosho.api_gateway.domains.tasks.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.xorosho.api_gateway.domains.tasks.dto.TaskRequest;
import edu.xorosho.api_gateway.domains.tasks.dto.TaskResponse;

@Service
public class TaskService {
    public TaskResponse createTask(TaskRequest request){
        Map<String, String> urls = new HashMap<>();
        for (Map.Entry<String, String> entry : request.getObjects().entrySet()) {
            String object = entry.getKey();
            String type = entry.getValue();
            urls.put(object, "https://example.com/upload/file" + type);
        }
        
        return new TaskResponse(123, urls);
    }
}
