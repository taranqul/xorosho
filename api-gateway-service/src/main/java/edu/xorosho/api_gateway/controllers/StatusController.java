package edu.xorosho.api_gateway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.xorosho.api_gateway.domains.status.dto.StatusResponse;
import edu.xorosho.api_gateway.domains.status.service.StatusService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoints for server information")
@RestController
@RequestMapping("/api/status")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }
    
    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @GetMapping("/summary")
    public StatusResponse getSummary() {
        return statusService.getSummary();
    }
    
}
