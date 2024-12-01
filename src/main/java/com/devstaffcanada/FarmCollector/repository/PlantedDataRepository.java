package com.devstaffcanada.FarmCollector.repository;

import com.devstaffcanada.FarmCollector.entity.Farm;
import com.devstaffcanada.FarmCollector.entity.PlantedData;
import com.devstaffcanada.FarmCollector.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantedDataRepository extends JpaRepository<PlantedData, Long> {
    List<PlantedData> findByFarmAndSeason(Farm farm, Season season);
    List<PlantedData> findByCropTypeAndSeason(String cropType, Season season);
}

