package com.studytracker.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class StudySession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int duration; // minutos

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}