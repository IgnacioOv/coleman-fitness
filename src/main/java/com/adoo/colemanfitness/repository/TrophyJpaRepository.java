package com.adoo.colemanfitness.repository;

import com.adoo.colemanfitness.model.entity.Trophy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrophyJpaRepository extends JpaRepository<Trophy,Long> {
}
