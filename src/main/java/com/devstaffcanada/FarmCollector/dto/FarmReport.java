package com.devstaffcanada.FarmCollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmReport {
    private String farmName;
    private String season;
    private List<CropReport> crops;
}

