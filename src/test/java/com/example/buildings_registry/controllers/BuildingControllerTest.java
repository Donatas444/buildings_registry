package com.example.buildings_registry.controllers;

import com.example.buildings_registry.model.Building;
import com.example.buildings_registry.services.BuildingService;
import javassist.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuildingControllerTest {

    @Mock
    BuildingService buildingService;
    @InjectMocks
    BuildingController buildingController = new BuildingController();

    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(buildingController).build();
    }

    @Test
    void getAllBuildings() throws NotFoundException {

        Building building1 = new Building();
        Building building2 = new Building();
        List<Building> buildings = new ArrayList<>();
        buildings.add(building1);
        buildings.add(building2);
        when(buildingService.getAllBuildings()).thenReturn(buildings);
        List<Building> result = buildingController.getAllBuildings();
        Assert.assertEquals(result.size(), 2);
        Assert.assertNotNull(result);
    }

    @Test
    void addBuilding() {
        Building building = new Building();
        when(buildingService.addBuilding(building, 1L)).thenReturn(building);
        building = buildingController.addBuilding(building, 1L);
        Assert.assertNotNull(building);
    }

    @Test
    void getBuilding() {
        Building building1 = new Building();
        Building building2 = new Building();
        List<Building> buildings = new ArrayList<>();
        buildings.add(building1);
        buildings.add(building2);
        when(buildingService.getBuildingById(1L)).thenReturn((building1));
        Building result = buildingController.getBuilding(1L);
        Assert.assertEquals(result, building1);
    }
}