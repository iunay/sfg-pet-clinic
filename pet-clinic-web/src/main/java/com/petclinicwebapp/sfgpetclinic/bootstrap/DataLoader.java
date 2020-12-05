package com.petclinicwebapp.sfgpetclinic.bootstrap;


import com.petclinicwebapp.sfgpetclinic.models.*;
import com.petclinicwebapp.sfgpetclinic.services.OwnerService;
import com.petclinicwebapp.sfgpetclinic.services.PetTypeService;
import com.petclinicwebapp.sfgpetclinic.services.SpecialityService;
import com.petclinicwebapp.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


// initialize data
@Component
public class DataLoader  implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {


        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }

        loadData();
    }

    private void loadData() {
        PetType dogType = new PetType();
        dogType.setName("Dog");
        petTypeService.save(dogType);
        PetType savedDogPetType = dogType;

        PetType catType = new PetType();
        catType.setName("Cat");
        petTypeService.save(catType);

        PetType savedCatPetType = catType;

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality savedRadiology = specialityService.save(radiology);


        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstname("Jil");
        owner1.setLastname("Eilish");
        owner1.setAddress("Washingston street 123");
        owner1.setCity("Washington");
        owner1.setTelephone("131312412");

        Pet jilPet = new Pet();
        jilPet.setPetType(savedDogPetType);
        jilPet.setOwner(owner1);
        jilPet.setBirthday(LocalDate.now());
        jilPet.setName("Bingo");
        owner1.getPets().add(jilPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("Nick");
        owner2.setLastname("Svicklo");
        owner2.setAddress("Washingston street 123");
        owner2.setCity("Washington");
        owner2.setTelephone("131312412");

        Pet nickPet = new Pet();
        nickPet.setPetType(savedCatPetType);
        nickPet.setOwner(owner2);
        nickPet.setBirthday(LocalDate.now());
        nickPet.setName("Lili");
        owner2.getPets().add(nickPet);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstname("Mario");
        vet1.setLastname("Ninno");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("Lucy");
        vet2.setLastname("Liu");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);
    }
}
