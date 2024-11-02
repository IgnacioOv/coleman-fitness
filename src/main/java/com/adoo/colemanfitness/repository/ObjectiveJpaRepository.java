package com.adoo.colemanfitness.repository;

import com.adoo.colemanfitness.model.entity.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectiveJpaRepository extends JpaRepository<Objective, Long> {
    // Métodos de consulta personalizados pueden ser añadidos aquí si es necesario
}
