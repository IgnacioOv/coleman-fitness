package com.adoo.colemanfitness.repository;

import com.adoo.colemanfitness.model.entity.Excercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcerciseJpaRepository extends JpaRepository<Excercise, Long> {
    // Métodos personalizados de consulta pueden ser añadidos aquí si es necesario
}
