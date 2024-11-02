package com.adoo.colemanfitness.repository;

import com.adoo.colemanfitness.model.entity.BodyMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyMeasureJpaRepository extends JpaRepository<BodyMeasurement,Long>{
}
