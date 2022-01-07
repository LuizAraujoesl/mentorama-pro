package com.systemhospital.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "historic")
public class Historic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private String diagnosticdescription;

    @OneToOne(cascade = {CascadeType.ALL}, targetEntity = Patient.class)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(cascade = {CascadeType.ALL}, targetEntity = ProfessionalMedicine.class)
    @JoinColumn(name = "professional_medicine_id")
    private ProfessionalMedicine professionalMedicine;
}
