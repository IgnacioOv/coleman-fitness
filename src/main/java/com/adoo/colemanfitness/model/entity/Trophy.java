package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "trophy_type", discriminatorType = DiscriminatorType.STRING)
@Data
public abstract class Trophy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;
}
