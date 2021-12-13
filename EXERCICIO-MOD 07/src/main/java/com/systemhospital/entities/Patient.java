package com.systemhospital.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name_patient")
    private String name;

    @Column(name = "gender_patient")
    private String gender;

    @Column(name = "date_nasc_patient")
    private LocalDateTime data;
}
