package edu.xorosho.api_gateway.domains.tasks.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

import edu.xorosho.api_gateway.domains.tasks.dto.TaskRequest;
import edu.xorosho.api_gateway.domains.tasks.exeptions.TaskSchemaNotValid;
import edu.xorosho.api_gateway.domains.tasks.models.TaskSchema;
import edu.xorosho.api_gateway.domains.tasks.repositories.TaskSchemaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskSchemeValidator {
    private final TaskSchemaRepository task_scheme_repository;
    private final ObjectMapper mapper = new ObjectMapper();
    private static final JsonSchemaFactory FACTORY = JsonSchemaFactory.getInstance(VersionFlag.V202012);
    public void validateScheme(TaskRequest request) {
        TaskSchema schema;
        try {
            schema = this.task_scheme_repository.getSchema(request.getTask_type()); 
        } catch (Exception e) {
            throw e;
        }

        JsonSchema jsonSchema = FACTORY.getSchema(schema.getSchema());
        ObjectNode data = mapper.createObjectNode();
        data.set("objects", mapper.valueToTree(request.getObjects()));
        data.set("payload", request.getPayload());
        Set<ValidationMessage> errors = jsonSchema.validate(data);
        if (!errors.isEmpty()) {
            throw new TaskSchemaNotValid();
        }
    }
    
    public TaskSchema getTaskSchema(String name) {
        try {
            TaskSchema schema = this.task_scheme_repository.getSchema(name); 
            return schema;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<String> getTasks(){
        return this.task_scheme_repository.getTasks();
    }
}
