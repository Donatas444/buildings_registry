package com.example.buildings_registry.controllers;

import com.example.buildings_registry.model.PropertyType;
import com.example.buildings_registry.services.PropertyTypeService;
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
class PropertyTypeControllerTest {

    @Mock
    PropertyTypeService propertyTypeService;

    @InjectMocks
    PropertyTypeController propertyTypeController = new PropertyTypeController();

    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(propertyTypeController).build();
    }

    @Test
    void addPropertyType() {

        PropertyType propertyType = new PropertyType();

        when(propertyTypeService.addPropertyType(propertyType)).thenReturn(propertyType);

        propertyType = propertyTypeController.addPropertyType(propertyType);

        Assert.assertNotNull(propertyType);
    }


    @Test
    void getAllPropertyTypes() {

        PropertyType propertyType1 = new PropertyType();
        PropertyType propertyType2 = new PropertyType();


        List<PropertyType> propertyTypes = new ArrayList<>();
        propertyTypes.add(propertyType1);
        propertyTypes.add(propertyType2);

        when(propertyTypeService.getAllPropertyTypes()).thenReturn(propertyTypes);

        List<PropertyType> result = propertyTypeController.getAllPropertyTypes();

        Assert.assertEquals(result.size(), 2);
        Assert.assertNotNull(result);
    }


    @Test
    void getPropertyById() {
        PropertyType propertyType1 = new PropertyType();
        PropertyType propertyType2 = new PropertyType();

        List<PropertyType> propertyTypes = new ArrayList<>();
        propertyTypes.add(propertyType1);
        propertyTypes.add(propertyType2);

        when(propertyTypeService.getPropertyTypeById(1L)).thenReturn(propertyType1);


        PropertyType result = propertyTypeController.getPropertyById(1L);

        Assert.assertEquals(result, propertyType1);
    }
}