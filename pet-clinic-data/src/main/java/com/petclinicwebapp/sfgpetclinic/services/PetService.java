package com.petclinicwebapp.sfgpetclinic.services;

import com.petclinicwebapp.sfgpetclinic.models.Pet;

import java.util.Set;

public interface PetService {

    Pet findByLastName(String lastname);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
