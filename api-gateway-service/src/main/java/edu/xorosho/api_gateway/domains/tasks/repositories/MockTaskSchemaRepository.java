package edu.xorosho.api_gateway.domains.tasks.repositories;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.xorosho.api_gateway.domains.tasks.exeptions.TaskNotFoundExeption;
import edu.xorosho.api_gateway.domains.tasks.models.TaskSchema;

@Repository
@Profile("test")
public class MockTaskSchemaRepository implements TaskSchemaRepository{
    private final Map<String, TaskSchema> mock_db;

    public MockTaskSchemaRepository() throws Exception{
        Map<String, TaskSchema> schemas = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        PathMatchingResourcePatternResolver resolver =
            new PathMatchingResourcePatternResolver();

        Resource[] resources = resolver.getResources("classpath:schemas/*.json");

        for (Resource resource : resources) {
            String filename = Objects.requireNonNull(resource.getFilename());
            String nameWithoutExt = filename.replaceFirst("\\.json$", "");

            try (InputStream is = resource.getInputStream()) {
                JsonNode json = mapper.readTree(is);
                schemas.put(nameWithoutExt, new TaskSchema(json));
            }
        }
        this.mock_db = schemas;
    }


    @Override
    public TaskSchema getSchema(String taskName) throws TaskNotFoundExeption {
        TaskSchema schema = this.mock_db.get(taskName);
        if (schema == null){
            throw new TaskNotFoundExeption();
        }    

        return schema;
    }

    @Override
    public List<String> getTasks() {
        return new ArrayList<>(this.mock_db.keySet());
    }

}
