package com.petclinicwebapp.sfgpetclinic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEntity{

    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;


    public Person() {
    }

    public Person(Long id, String firstname, String lastname) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
