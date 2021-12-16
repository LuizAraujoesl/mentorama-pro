package com.systemhospital.entitiesDto;

import com.systemhospital.entities.Patient;
import com.systemhospital.entities.ProfessionalMedicine;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.JoinColumn;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
public class HistoricDto {

    private Long id;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private String diagnosticdescription;
    private Patient patient;
    private ProfessionalMedicine professionalMedicine;


}
