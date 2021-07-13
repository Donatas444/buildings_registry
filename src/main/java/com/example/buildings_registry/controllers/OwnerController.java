package com.example.buildings_registry.controllers;

import com.example.buildings_registry.model.Owner;
import com.example.buildings_registry.services.CalculationsService;
import com.example.buildings_registry.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class OwnerController {

    @Autowired
    private CalculationsService calculationsService;
    @Autowired
    private OwnerService ownerService;

    @PostMapping(path = "/addowner", consumes = "application/json", produces = "application/json")
    public Owner addOwner(@RequestBody Owner owner) {
        return ownerService.addOwner(owner);
    }

    @PutMapping("/owner")
    public Owner editOwner(@RequestBody Owner owner) {
        return ownerService.addOwner(owner);
    }

    @DeleteMapping("/deleteowner")
    public void deleteOwner(@RequestBody Owner owner) {
        ownerService.delete(owner);
    }

    @GetMapping("/owners")
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("/owner/{id}")
    public Owner getOwnerById(@PathVariable(value = "id") Long id) {

        return ownerService.getOwnerById(id);
    }

    @GetMapping("/ownertax/{id}")
    public double getOwnerTax(@PathVariable(value = "id") Long id) {
        return calculationsService.getTax(id);
    }
}
