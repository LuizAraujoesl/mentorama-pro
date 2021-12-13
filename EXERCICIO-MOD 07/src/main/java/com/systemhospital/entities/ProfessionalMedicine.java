package com.systemhospital.entities;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class ProfessionalMedicine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricula", nullable = false)
    private Integer matricula;

    @Column(name = "professional_name")
    private String name;

    @Column(name = "professional_gender")
    private String gender;

    @Column(name = "professional_department")
    private String department;

    @Column(name = "professional_office")
    private String office;

    @Column(name = "professional_phone")
    private String phone;
}
