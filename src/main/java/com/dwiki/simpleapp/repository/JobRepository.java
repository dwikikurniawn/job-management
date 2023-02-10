package com.dwiki.simpleapp.repository;

import com.dwiki.simpleapp.dto.JobDetailDto;
import com.dwiki.simpleapp.dto.JobDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JobRepository {


    private final RestTemplate restTemplate;
    String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";

    public List<JobDto> findAll(){
        ResponseEntity<List<JobDto>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<JobDto>>() {
        });
        List<JobDto> jobs = responseEntity.getBody();
        return jobs;
    }

    public List<JobDetailDto> findAllDetails(){
        ResponseEntity<List<JobDetailDto>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<JobDetailDto>>() {
                });
        List<JobDetailDto> jobs = responseEntity.getBody();
        return jobs;
    }
}
