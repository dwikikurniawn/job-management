package com.dwiki.simpleapp.service.impl;

import com.dwiki.simpleapp.dto.JobDetailDto;
import com.dwiki.simpleapp.dto.JobDto;
import com.dwiki.simpleapp.repository.JobRepository;
import com.dwiki.simpleapp.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public List<JobDto> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public List<JobDetailDto> getAllDetails() {
        return jobRepository.findAllDetails();
    }
}