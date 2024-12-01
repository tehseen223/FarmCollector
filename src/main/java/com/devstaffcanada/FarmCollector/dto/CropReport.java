package com.devstaffcanada.FarmCollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CropReport {
    private String cropType;
    private double expectedProduct;
    private double actualProduct;
}

