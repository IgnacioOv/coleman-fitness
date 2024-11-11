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
    private String state;

    @Column(name = "objective_type", insertable = false, updatable = false)
    private String objectiveType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;


    @OneToOne(mappedBy = "objective")
    private Routine routine;

    @OneToOne(mappedBy = "objective")
    private ObjectiveMeasurement objectiveMeasurement;



    public abstract ObjectiveMeasurement calculateObjectiveMeasurements(BodyMeasurement bodyMeasurement);
    public abstract void verifyObjectiveState(BodyMeasurement bodyMeasurement);

}