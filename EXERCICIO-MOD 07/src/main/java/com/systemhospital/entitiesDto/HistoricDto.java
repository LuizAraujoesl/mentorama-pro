package com.systemhospital.entitiesDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoricDto {

    private Integer id;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private String diagnosticDescription;
}
