package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "objective_type", discriminatorType = DiscriminatorType.STRING)
@Entity
@ToString
public abstract class Objective {
    private Float minAerobicLevel;
    private Float maxAerobicLevel;
    private Long minTrainTime;
    private Long maxTrainTime;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;


    @OneToOne(mappedBy = "objective")
    private Routine routine;




}
