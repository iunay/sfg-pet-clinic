package com.petclinicwebapp.sfgpetclinic.repositories;

import com.petclinicwebapp.sfgpetclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {

}
