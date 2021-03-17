package com.example.buildings_registry.repositories;

import com.example.buildings_registry.model.Building;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Long> {

    @Query(value = "SELECT * FROM building WHERE building.owner_id = :owner_id", nativeQuery = true)
    List<Building> findAllBuildingsByOwner(Long owner_id);
}
