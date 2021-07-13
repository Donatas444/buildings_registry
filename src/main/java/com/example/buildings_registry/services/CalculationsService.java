package com.example.buildings_registry.services;

import com.example.buildings_registry.model.Building;
import com.example.buildings_registry.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationsService {
    @Autowired
    private BuildingRepository buildingRepository;

    public double getTax(Long id) {
        List<Building> buildings = buildingRepository.findAllBuildingsByOwner(id);
        double result = 0;
        for (Building building : buildings) {
            result += (double) building.getValue() / 100 * building.getPropertyType().getTaxPercentage();
            if (building.getValue() < 100) {
                result += 1;
            }
        }
        return result;
    }
}
