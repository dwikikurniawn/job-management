package com.dwiki.simpleapp.service;

import com.dwiki.simpleapp.dto.JobDetailDto;
import com.dwiki.simpleapp.dto.JobDto;

import java.util.List;

public interface JobService {

    List<JobDto> getAll();

    List<JobDetailDto> getAllDetails();
}
