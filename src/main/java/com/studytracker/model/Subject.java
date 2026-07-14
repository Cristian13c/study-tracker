package com.studytracker.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Relación con usuario
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}