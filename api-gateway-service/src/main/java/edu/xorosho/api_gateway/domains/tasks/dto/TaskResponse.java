package edu.xorosho.api_gateway.domains.tasks.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskResponse {
   private Integer task_id;
   private Map<String, String> urls;
}
