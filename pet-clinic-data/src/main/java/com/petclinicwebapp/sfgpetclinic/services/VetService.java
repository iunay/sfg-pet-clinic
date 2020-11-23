package com.petclinicwebapp.sfgpetclinic.services;

import com.petclinicwebapp.sfgpetclinic.models.Vet;

import java.util.Set;

public interface VetService {

    Vet findByLastName(String lastname);

    Vet save(Vet vet);

    Set<Vet> findAll();

}
