package com.adoo.colemanfitness.repository;

import com.adoo.colemanfitness.model.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineJpaRepository extends JpaRepository<Routine, Long> {
    // Aquí puedes agregar métodos de consulta personalizados si es necesario
}
