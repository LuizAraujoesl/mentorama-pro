package com.systemhospital.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Historic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "check_in")
    private LocalDateTime checkin;

    @Column(name = "check_out")
    private LocalDateTime checkout;

    @Column(name = "diag_description")
    private String diagnosticDescription;
}
