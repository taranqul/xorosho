package edu.xorosho.api_gateway.domains.tasks.models;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskSchema {
    private JsonNode schema;
}
