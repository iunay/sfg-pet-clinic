package com.petclinicwebapp.sfgpetclinic.repositories;

import com.petclinicwebapp.sfgpetclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByLastname(String lastname);
}
