package com.adoo.colemanfitness.repository;

import com.adoo.colemanfitness.model.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AthleteJpaRepository extends JpaRepository<Athlete, Long> {

    // Método para encontrar atletas por email
    List<Athlete> findAllByEmail(String email);
}
