package com.devstaffcanada.FarmCollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestedDataRequest {
    private String farmName;
    private String season;
    private String fieldName;
    private String cropType;
    private double actualHarvestedProduct;
}
