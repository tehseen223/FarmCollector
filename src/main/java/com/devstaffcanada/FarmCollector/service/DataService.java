package com.devstaffcanada.FarmCollector.service;

import com.devstaffcanada.FarmCollector.dto.HarvestedDataRequest;
import com.devstaffcanada.FarmCollector.dto.PlantedDataRequest;
import com.devstaffcanada.FarmCollector.entity.Farm;
import com.devstaffcanada.FarmCollector.entity.HarvestedData;
import com.devstaffcanada.FarmCollector.entity.PlantedData;
import com.devstaffcanada.FarmCollector.entity.Season;
import com.devstaffcanada.FarmCollector.exception.ResourceNotFoundException;
import com.devstaffcanada.FarmCollector.repository.FarmRepository;
import com.devstaffcanada.FarmCollector.repository.HarvestedDataRepository;
import com.devstaffcanada.FarmCollector.repository.PlantedDataRepository;
import com.devstaffcanada.FarmCollector.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataService {
    private final FarmRepository farmRepository;
    private final SeasonRepository seasonRepository;
    private final PlantedDataRepository plantedDataRepository;
    private final HarvestedDataRepository harvestedDataRepository;

    public void savePlantedData(PlantedDataRequest request) {
        Farm farm = farmRepository.findByName(request.getFarmName())
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found: " + request.getFarmName()));
        Season season = seasonRepository.findByName(request.getSeason())
                .orElseThrow(() -> new ResourceNotFoundException("Season not found: " + request.getSeason()));

        PlantedData plantedData = new PlantedData(null, farm, season, request.getFieldName(),
                request.getCropType(), request.getPlantingArea(), request.getExpectedProduct());
        plantedDataRepository.save(plantedData);
    }

    public void saveHarvestedData(HarvestedDataRequest request) {
        Farm farm = farmRepository.findByName(request.getFarmName())
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found: " + request.getFarmName()));
        Season season = seasonRepository.findByName(request.getSeason())
                .orElseThrow(() -> new ResourceNotFoundException("Season not found: " + request.getSeason()));

        HarvestedData harvestedData = new HarvestedData(null, farm, season, request.getFieldName(),
                request.getCropType(), request.getActualHarvestedProduct());
        harvestedDataRepository.save(harvestedData);
    }
}


