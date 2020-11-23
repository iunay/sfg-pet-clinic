package com.petclinicwebapp.sfgpetclinic.services;

import com.petclinicwebapp.sfgpetclinic.models.Owner;

import java.util.Set;

public interface OwnerService {

   Owner findById(Long id);

   Owner findByLastName(String lastname);

   Owner save(Owner owner);

   Set<Owner> findAll();

}
