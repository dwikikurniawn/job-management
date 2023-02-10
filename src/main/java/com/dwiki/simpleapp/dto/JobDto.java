package com.dwiki.simpleapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class JobDto {

    private String id;
    private String type;
    private String company;
    private String location;
    private String title;
}
