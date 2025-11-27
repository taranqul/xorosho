package edu.xorosho.api_gateway.domains.tasks.repositories;

import java.util.List;

import edu.xorosho.api_gateway.domains.tasks.exeptions.TaskNotFoundExeption;
import edu.xorosho.api_gateway.domains.tasks.models.TaskSchema;

public interface TaskSchemaRepository {
    TaskSchema getSchema(String taskName) throws TaskNotFoundExeption;
    List<String> getTasks();
}
