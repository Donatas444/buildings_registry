package com.example.buildings_registry.services;

import com.example.buildings_registry.model.Owner;
import com.example.buildings_registry.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public Owner addOwner(Owner owner) {
        ownerRepository.save(owner);
        return owner;
    }

    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    public List<Owner> getAllOwners() {
        return (List<Owner>) ownerRepository.findAll();
    }

    public Owner getOwnerById(Long id) throws NullPointerException {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (owner.isPresent()) {
            return owner.get();
        } else {
            throw new NullPointerException("Owner not found: " + id);
        }
    }
}
