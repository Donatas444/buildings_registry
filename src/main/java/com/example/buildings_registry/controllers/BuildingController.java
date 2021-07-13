package com.example.buildings_registry.controllers;

import com.example.buildings_registry.model.Building;
import com.example.buildings_registry.services.BuildingService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @GetMapping("/buildings")
    public List<Building> getAllBuildings() throws NotFoundException {
        List<Building> buildings = buildingService.getAllBuildings();
        if (buildings.isEmpty()) {
            throw new NotFoundException("Buildings not found");
        }
        return buildings;
    }

    @PostMapping("/addbuilding/{propertyTypeId}")
    public Building addBuilding(
            @RequestBody Building building,
            @PathVariable("propertyTypeId") Long propertyTypeId) {
        return buildingService.addBuilding(building, propertyTypeId);
    }

    @PutMapping("/editbuilding/{ownerId}/{propertyTypeId}")
    public Building editBuilding(
            @RequestBody Building building,
            @PathVariable("ownerId") Long ownerId,
            @PathVariable("propertyTypeId") Long propertyTypeId) {
        return buildingService.updateBuilding(building, ownerId, propertyTypeId);
    }

    @DeleteMapping("/deletebuilding")
    public void deleteBuilding(@RequestBody Building building) {
        buildingService.deleteBuilding(building);
    }

    @GetMapping("/building/{id}")
    public Building getBuilding(@PathVariable("id") Long id) {
        return buildingService.getBuildingById(id);
    }
}
