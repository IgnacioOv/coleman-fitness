package com.adoo.colemanfitness.repository;

import com.adoo.colemanfitness.model.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AthleteJpaRepository extends JpaRepository<Athlete,Long> {
}
