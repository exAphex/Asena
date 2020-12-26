package com.asena.scimgateway.controller;

import java.util.List;

import com.asena.scimgateway.model.dto.LogDTO;
import com.asena.scimgateway.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@Validated
@RequestMapping("/api/v1/log")
public class LogController {
    
    @Autowired
    private LogService logService;

    @GetMapping("")
    public List<LogDTO> getLogs() {
        return LogDTO.toDTO(logService.list());
    }

    @DeleteMapping("")
    public void deleteLogs() {
        logService.deleteAll();
    }

    @GetMapping("/count")
    public long getLogCount() {
        return logService.getCount();
    }
}