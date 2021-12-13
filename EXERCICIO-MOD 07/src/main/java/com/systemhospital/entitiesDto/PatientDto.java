package com.systemhospital.entitiesDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PatientDto {

    private Integer id;
    private String name;
    private String gender;
    private LocalDateTime data;
}
