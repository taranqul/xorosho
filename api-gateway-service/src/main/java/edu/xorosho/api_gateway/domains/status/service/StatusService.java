package edu.xorosho.api_gateway.domains.status.service;

import org.springframework.stereotype.Service;

import edu.xorosho.api_gateway.domains.status.dto.StatusResponse;

@Service
public class StatusService {
    public StatusResponse getSummary(){
        return new StatusResponse("healthy");
    }
}
