package com.example.buildings_registry.controllers;

import com.example.buildings_registry.model.PropertyType;
import com.example.buildings_registry.services.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PropertyTypeController {
    @Autowired
    private PropertyTypeService propertyTypeService;

    @PostMapping("/addpropertytype")
    public PropertyType addPropertyType(@RequestBody PropertyType propertyType) {
        return propertyTypeService.addPropertyType(propertyType);
    }

    @PutMapping("/editPropertyType")
    public PropertyType editPropertyType(@RequestBody PropertyType propertyType) {
        return propertyTypeService.addPropertyType(propertyType);
    }

    @DeleteMapping("/deleteproperty")
    public void deleteProperty(@RequestBody PropertyType propertyType) {
        propertyTypeService.deletePropertyType(propertyType);
    }

    @GetMapping("/properties")
    public List<PropertyType> getAllPropertyTypes() {
        return propertyTypeService.getAllPropertyTypes();
    }

    @GetMapping("/property/{id}")
    public PropertyType getPropertyById(@PathVariable("id") Long id) {
        return propertyTypeService.getPropertyTypeById(id);
    }
}
