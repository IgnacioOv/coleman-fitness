package com.adoo.colemanfitness.model.entity;


import com.adoo.colemanfitness.repository.AthleteJpaRepository;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue("vanity")
public class VanityTrophy extends Trophy{
    public Boolean verifyTrophy(Athlete athlete) {
        Map<Integer, Integer> monthCountMap = new HashMap<>();
        if (athlete.getBodyMeasurementList() != null || !athlete.getBodyMeasurementList().isEmpty()) {
            List<BodyMeasurement> measurements = athlete.getBodyMeasurementList();
            for (int i = 0; i < measurements.size(); i++) {
                BodyMeasurement measurement = measurements.get(i);
                Date test = measurement.getDate();
                LocalDate localDate = test.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int month = localDate.getMonthValue();
                monthCountMap.put(month, monthCountMap.getOrDefault(month, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : monthCountMap.entrySet()) {
                if (entry.getValue() > 3){
                    return true;
                }
            }
        }
        return false;
    }

}
