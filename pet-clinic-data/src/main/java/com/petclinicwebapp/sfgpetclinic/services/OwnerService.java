package com.petclinicwebapp.sfgpetclinic.services;

import com.petclinicwebapp.sfgpetclinic.models.Owner;

public interface OwnerService  extends CrudService<Owner,Long>{

   Owner findByLastName(String lastname);

}
