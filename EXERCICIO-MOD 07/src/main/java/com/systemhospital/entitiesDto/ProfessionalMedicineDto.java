package com.systemhospital.entitiesDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class ProfessionalMedicineDto {

    private Integer matricula;
    private String name;
    private String gender;
    private String department;
    private String office;
    private String phone;
}
