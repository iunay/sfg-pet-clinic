package com.petclinicwebapp.sfgpetclinic.repositories;

import com.petclinicwebapp.sfgpetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository  extends CrudRepository<PetType,Long> {
}
