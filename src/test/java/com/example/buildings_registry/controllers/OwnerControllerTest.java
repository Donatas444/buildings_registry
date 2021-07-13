package com.example.buildings_registry.controllers;

import com.example.buildings_registry.model.Building;
import com.example.buildings_registry.model.Owner;
import com.example.buildings_registry.model.PropertyType;
import com.example.buildings_registry.services.CalculationsService;
import com.example.buildings_registry.services.OwnerService;
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
class OwnerControllerTest {
    @Mock
    OwnerService ownerService;
    @Mock
    CalculationsService calculationsService;
    @InjectMocks
    OwnerController ownerController = new OwnerController();
    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void addOwner() {
        Owner owner = new Owner();
        when(ownerService.addOwner(owner)).thenReturn(owner);
        owner = ownerController.addOwner(owner);
        Assert.assertNotNull(owner);
    }

    @Test
    void getAllOwners() {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        Owner owner3 = new Owner();
        List<Owner> owners = new ArrayList<>();
        owners.add(owner1);
        owners.add(owner2);
        owners.add(owner3);
        when(ownerService.getAllOwners()).thenReturn(owners);
        List<Owner> result = ownerController.getAllOwners();
        Assert.assertEquals(result.size(), 3);
        Assert.assertNotNull(result);
    }

    @Test
    void getOwnerById() {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        List<Owner> owners = new ArrayList<>();
        owners.add(owner1);
        owners.add(owner2);
        when(ownerService.getOwnerById(2L)).thenReturn(owner2);
        Owner result = ownerController.getOwnerById(2L);
        Assert.assertEquals(result, owner2);
    }

    @Test
    void getOwnerTax() {
        Owner owner = new Owner();
        owner.setOwnerId(1L);
        PropertyType propertyType = new PropertyType();
        propertyType.setPropertyTypeId(1L);
        propertyType.setTaxPercentage(10);
        Building building = new Building();
        building.setValue(1000);
        building.setOwner(owner);
        building.setPropertyType(propertyType);
        when(calculationsService.getTax(1L)).thenReturn(100.0);
        Double expectedTaxes = (building.getValue() / 100) * propertyType.getTaxPercentage();
        Double actualTaxes = calculationsService.getTax(1L);
        Assert.assertEquals(expectedTaxes, actualTaxes);
    }
}