package com.systemhospital.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@MappedSuperclass
public class GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @Transient
    private String name;

    @JsonIgnore
    @Transient
    private LocalDateTime checkin;

    @JsonIgnore
    @Transient
    private LocalDateTime checkout;

}