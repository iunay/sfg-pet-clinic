package com.petclinicwebapp.sfgpetclinic.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class Person extends BaseEntity{

    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;


    public Person() {
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
