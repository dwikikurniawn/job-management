package com.dwiki.simpleapp.mapper.impl;

import com.dwiki.simpleapp.dto.JobDetailDto;
import com.dwiki.simpleapp.dto.JobDto;
import com.dwiki.simpleapp.entity.JobEntity;
import com.dwiki.simpleapp.mapper.JobMapper;
import org.springframework.stereotype.Component;

@Component
public class JobMapperImpl implements JobMapper {

    @Override
    public JobDetailDto toDetailDto(JobEntity job) {
        return JobDetailDto
                .builder()
                .id(job.getId())
                .type(job.getType())
                .url(job.getUrl())
                .company(job.getCompany())
                .companyUrl(job.getCompanyUrl())
                .location(job.getLocation())
                .title(job.getTitle())
                .description(job.getDescription())
                .howToApply(job.getHowToApply())
                .build();
    }

    @Override
    public JobDto toDto(JobEntity job) {
        return JobDto.builder()
                .id(job.getId())
                .type(job.getType())
                .company(job.getCompany())
                .location(job.getLocation())
                .title(job.getTitle())
                .build();
    }
}
