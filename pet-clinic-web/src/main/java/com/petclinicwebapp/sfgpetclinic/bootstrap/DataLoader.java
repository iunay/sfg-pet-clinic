package com.petclinicwebapp.sfgpetclinic.bootstrap;


import com.petclinicwebapp.sfgpetclinic.models.Owner;
import com.petclinicwebapp.sfgpetclinic.models.Vet;
import com.petclinicwebapp.sfgpetclinic.services.OwnerService;
import com.petclinicwebapp.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// initialize data
@Component
public class DataLoader  implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstname("Jil");
        owner1.setLastname("Eilish");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("Nick");
        owner2.setLastname("Svicklo");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstname("Mario");
        vet1.setLastname("Ninno");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("Lucy");
        vet2.setLastname("Liu");

        vetService.save(vet2);


    }
}
