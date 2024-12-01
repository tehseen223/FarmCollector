package com.devstaffcanada.FarmCollector.repository;

import com.devstaffcanada.FarmCollector.entity.Farm;
import com.devstaffcanada.FarmCollector.entity.HarvestedData;
import com.devstaffcanada.FarmCollector.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HarvestedDataRepository extends JpaRepository<HarvestedData, Long> {
    List<HarvestedData> findByFarmAndSeason(Farm farm, Season season);
    List<HarvestedData> findByCropTypeAndSeason(String cropType, Season season);
}

