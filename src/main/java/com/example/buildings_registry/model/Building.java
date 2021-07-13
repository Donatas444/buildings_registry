package com.example.buildings_registry.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buildingId;
    private String city;
    private String street;
    private String number;
    private double sizeInSquareMeters;
    private int value;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ownerId")
    @JsonBackReference(value = "owner")
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "propertyTypeId")
    @JsonBackReference(value = "propertyType")
    private PropertyType propertyType;

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getSizeInSquareMeters() {
        return sizeInSquareMeters;
    }

    public void setSizeInSquareMeters(double sizeInSquareMeters) {
        this.sizeInSquareMeters = sizeInSquareMeters;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }
}
