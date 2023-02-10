package com.dwiki.simpleapp.mapper;

import com.dwiki.simpleapp.dto.JobDetailDto;
import com.dwiki.simpleapp.dto.JobDto;
import com.dwiki.simpleapp.entity.JobEntity;

public interface JobMapper {

    JobDetailDto toDetailDto(JobEntity job);

    JobDto toDto(JobEntity job);
}
