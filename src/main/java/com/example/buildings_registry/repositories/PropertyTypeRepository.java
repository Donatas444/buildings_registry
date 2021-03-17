package com.example.buildings_registry.repositories;

import com.example.buildings_registry.model.PropertyType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyTypeRepository extends CrudRepository<PropertyType, Long> {
}
