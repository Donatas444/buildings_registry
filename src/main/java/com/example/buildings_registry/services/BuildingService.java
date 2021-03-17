package com.example.buildings_registry.services;

import com.example.buildings_registry.model.Building;
import com.example.buildings_registry.model.Owner;
import com.example.buildings_registry.model.PropertyType;
import com.example.buildings_registry.repositories.BuildingRepository;
import com.example.buildings_registry.repositories.OwnerRepository;
import com.example.buildings_registry.repositories.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;


    public Building addBuilding(Building building, Long propertyTypeId) {
        PropertyType propertyType = propertyTypeRepository.findById(propertyTypeId).orElse(new PropertyType());
        building.setOwner(null);
        building.setPropertyType(propertyType);
        buildingRepository.save(building);
        return building;
    }

    public Building updateBuilding(Building building, Long ownerId, Long propertyTypeId) {
        Owner owner = ownerRepository.findById(ownerId).orElse(new Owner());
        PropertyType propertyType = propertyTypeRepository.findById(propertyTypeId).orElse(new PropertyType());
        building.setOwner(owner);
        building.setPropertyType(propertyType);
        buildingRepository.save(building);
        return building;
    }

    public void deleteBuilding(Building building) {
        buildingRepository.delete(building);
    }

    public List<Building> getAllBuildings() {
        return (List<Building>) buildingRepository.findAll();
    }

    public Building getBuildingById(Long id) {
        Optional<Building> building = buildingRepository.findById(id);
        if (building.isPresent()) {
            return building.get();
        } else {
            throw new RuntimeException("Building not found: " + id);
        }
    }
}
