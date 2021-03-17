package com.example.buildings_registry.services;

import com.example.buildings_registry.model.PropertyType;
import com.example.buildings_registry.repositories.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyTypeService {

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    public PropertyType addPropertyType(PropertyType propertyType) {
        propertyTypeRepository.save(propertyType);
        return propertyType;
    }

    public void deletePropertyType(PropertyType propertyType) {
        propertyTypeRepository.delete(propertyType);
    }

    public List<PropertyType> getAllPropertyTypes() {
        return (List<PropertyType>) propertyTypeRepository.findAll();
    }

    public PropertyType getPropertyTypeById(Long id) {
        Optional<PropertyType> propertyType = propertyTypeRepository.findById(id);
        if (propertyType.isPresent()) {
            return propertyType.get();
        } else {
            throw new RuntimeException("Property type not found: " + id);
        }
    }
}
