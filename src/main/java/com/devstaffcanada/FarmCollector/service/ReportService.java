package com.devstaffcanada.FarmCollector.service;

import com.devstaffcanada.FarmCollector.dto.CropReport;
import com.devstaffcanada.FarmCollector.dto.FarmReport;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final PlantedDataRepository plantedDataRepository;
    private final HarvestedDataRepository harvestedDataRepository;

    // Fetch all farm reports (all seasons) without any filters
    public List<FarmReport> getAllFarmReports() {
        // Fetch all planted and harvested data
        List<PlantedData> plantedDataList = plantedDataRepository.findAll();
        List<HarvestedData> harvestedDataList = harvestedDataRepository.findAll();

        Map<String, FarmReport> farmReportsMap = new HashMap<>();

        // Loop over planted data and organize it by farm
        for (PlantedData plantedData : plantedDataList) {
            String farmName = plantedData.getFarm().getName();
            String season = plantedData.getSeason().getName(); // Assuming season is available in PlantedData


            // If farm doesn't exist, create a new one
            if (!farmReportsMap.containsKey(farmName)) {
                    farmReportsMap.put(farmName,new FarmReport(farmName, season, new ArrayList<>()));
            }

            // Find the corresponding harvested data for this crop
            double actualProduct = 0;
            for (HarvestedData harvestedData : harvestedDataList) {
                if (harvestedData.getFarm().getName().equals(farmName) &&
                        harvestedData.getCropType().equals(plantedData.getCropType())) {
                    actualProduct = harvestedData.getActualHarvestedProduct();
                    break;
                }
            }

            // Create crop report for this crop type
            CropReport cropReport = new CropReport(
                    plantedData.getCropType(),
                    plantedData.getExpectedProduct(),
                    actualProduct
            );

            // Add this crop report to the farm's report
            farmReportsMap.get(farmName).getCrops().add(cropReport);
        }

        // Return all farm reports
        return new ArrayList<>(farmReportsMap.values());
    }

    // Fetch all crop reports (all crops and all seasons) without any filters
    public List<CropReport> getAllCropReports() {
        // Fetch all planted and harvested data
        List<PlantedData> plantedDataList = plantedDataRepository.findAll();
        List<HarvestedData> harvestedDataList = harvestedDataRepository.findAll();

        List<CropReport> cropReports = new ArrayList<>();

        // Loop over planted data and create reports for each crop
        for (PlantedData plantedData : plantedDataList) {
            // Find the corresponding harvested data for this crop
            double actualProduct = 0;
            for (HarvestedData harvestedData : harvestedDataList) {
                if (harvestedData.getCropType().equals(plantedData.getCropType())) {
                    actualProduct = harvestedData.getActualHarvestedProduct();
                    break;
                }
            }

            // Create a crop report
            CropReport cropReport = new CropReport(
                    plantedData.getCropType(),
                    plantedData.getExpectedProduct(),
                    actualProduct
            );

            // Add the crop report to the list
            cropReports.add(cropReport);
        }

        // Return the list of crop reports
        return cropReports;
    }
}


