package com.dwiki.simpleapp.controller;

import com.dwiki.simpleapp.dto.JobDetailDto;
import com.dwiki.simpleapp.dto.JobDto;
import com.dwiki.simpleapp.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping()
    public ResponseEntity<List<JobDto>> getJobs() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jobService.getAll());
    }

    @GetMapping("/detail")
    public ResponseEntity<List<JobDetailDto>> getJobDetails() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jobService.getAllDetails());
    }
}