package com.systemhospital.entitiesDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class PatientDto {

    private Integer id;
    private String name;
    private String gender;
    private String phone;
    private Date data;
}
