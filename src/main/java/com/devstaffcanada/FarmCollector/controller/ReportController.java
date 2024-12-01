package com.devstaffcanada.FarmCollector.controller;

import com.devstaffcanada.FarmCollector.dto.CropReport;
import com.devstaffcanada.FarmCollector.dto.FarmReport;
import com.devstaffcanada.FarmCollector.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    // Endpoint to get all farm reports for all seasons
    @GetMapping("/farms")
    public ResponseEntity<List<FarmReport>> getFarmReports() {
        List<FarmReport> farmReports = reportService.getAllFarmReports();
        return ResponseEntity.ok(farmReports);
    }

    // Endpoint to get crop reports for all seasons and all crops
    @GetMapping("/crops")
    public ResponseEntity<List<CropReport>> getCropReports() {
        List<CropReport> cropReports = reportService.getAllCropReports();
        return ResponseEntity.ok(cropReports);
    }
}

