package com.ikeasistencia.examen.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String paternalSurname;
    private String maternalSurname;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
