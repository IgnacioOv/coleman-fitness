package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="routine_id")
    private Routine routine;
    @OneToMany(mappedBy = "training")
    @ToString.Exclude
    private List<TrainingExcercise> excerciseList;
    private Long duration;
    private String muscleGroup;
    private Boolean assisted;
}
