package com.petclinicwebapp.sfgpetclinic.services.springdatajpa;

import com.petclinicwebapp.sfgpetclinic.models.Owner;
import com.petclinicwebapp.sfgpetclinic.repositories.OwnerRepository;
import com.petclinicwebapp.sfgpetclinic.repositories.PetRepository;
import com.petclinicwebapp.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LASTNAME = "Smith";
     @Mock
     OwnerRepository ownerRepository;
     @Mock
     PetRepository petRepository;
     @Mock
     PetTypeRepository petTypeRepository;
     @InjectMocks
     OwnerSDJpaService ownerSDJpaService;
    Owner returnOwner;

     @BeforeEach
    void setUp() {
         //setup instance of the object
         returnOwner = Owner.builder().id(1L).lastname(LASTNAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();

        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2,owners.size());

    }

    @Test
    void findById() {
         when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
         Owner owner = ownerSDJpaService.findById(1L);
         assertNotNull(owner);
    }
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerSDJpaService.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
         Owner ownerToBesaved = Owner.builder().id(1L).build();
         when(ownerRepository.save(any())).thenReturn(returnOwner);
         Owner savedOwner = ownerSDJpaService.save(ownerToBesaved);
         assertNotNull(savedOwner);
         verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
         ownerSDJpaService.delete(returnOwner);
         verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {

         ownerSDJpaService.deleteById(1L);
         verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {

         returnOwner = Owner.builder().id(1L).lastname(LASTNAME).build();
      when(ownerSDJpaService.findByLastName(any())).thenReturn(returnOwner);
      Owner smith = ownerRepository.findByLastname(LASTNAME);
      assertEquals(LASTNAME, smith.getLastname());
      verify(ownerRepository).findByLastname(any());
    }
}