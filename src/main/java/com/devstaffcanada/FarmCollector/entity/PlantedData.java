package com.devstaffcanada.FarmCollector.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantedData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Farm farm;

    @ManyToOne
    private Season season;

    private String fieldName;
    private String cropType;
    private double plantingArea;
    private double expectedProduct;
}

