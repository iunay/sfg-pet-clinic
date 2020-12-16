package com.petclinicwebapp.sfgpetclinic.repositories;

import com.petclinicwebapp.sfgpetclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
