package edu.xorosho.api_gateway.domains.tasks.dto;


import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskSchemaResponse {
    private JsonNode requestSchema;
}
