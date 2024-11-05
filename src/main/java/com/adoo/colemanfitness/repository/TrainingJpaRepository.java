package com.adoo.colemanfitness.repository;

import com.adoo.colemanfitness.model.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingJpaRepository extends JpaRepository<Training, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario
}
