package edu.xorosho.api_gateway.domains.tasks.dto;


import com.networknt.schema.JsonSchema;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskSchemaResponse {
    private JsonSchema requestSchema;
}
