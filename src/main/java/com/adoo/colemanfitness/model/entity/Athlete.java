package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    @Column(unique = true) // Asegurando que el email sea único
    private String email;
    private String password;
    private String sex;
    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Trophy> trophyList;
    @ToString.Exclude
    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<BodyMeasurement> bodyMeasurementList;
    @OneToMany(mappedBy = "athlete",cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private List<Objective> objectives;





}
