package com.systemhospital.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "professional_medicine")
public class ProfessionalMedicine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricula", nullable = false)
    private Long matricula;
    private String name;
    private String gender;
    private String department;
    private String office;
    private String phone;
}
