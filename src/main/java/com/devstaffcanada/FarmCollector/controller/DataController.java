package com.devstaffcanada.FarmCollector.controller;

import com.devstaffcanada.FarmCollector.dto.HarvestedDataRequest;
import com.devstaffcanada.FarmCollector.dto.PlantedDataRequest;
import com.devstaffcanada.FarmCollector.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DataController {
    private final DataService dataService;

    @PostMapping("/planted")
    public ResponseEntity<Void> submitPlantedData(@RequestBody PlantedDataRequest request) {
        dataService.savePlantedData(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/harvested")
    public ResponseEntity<Void> submitHarvestedData(@RequestBody HarvestedDataRequest request) {
        dataService.saveHarvestedData(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

