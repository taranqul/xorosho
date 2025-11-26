package edu.xorosho.api_gateway.domains.tasks.dto;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskRequest {
    private String task_type;
    private Map<String, String> objects;
    private JsonNode payload;
}
