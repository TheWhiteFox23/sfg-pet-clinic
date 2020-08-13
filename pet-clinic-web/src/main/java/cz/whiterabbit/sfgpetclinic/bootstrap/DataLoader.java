package cz.whiterabbit.sfgpetclinic.bootstrap;

import cz.whiterabbit.sfgpetclinic.model.*;
import cz.whiterabbit.sfgpetclinic.services.OwnerService;
import cz.whiterabbit.sfgpetclinic.services.PetTypeService;
import cz.whiterabbit.sfgpetclinic.services.SpecialitieService;
import cz.whiterabbit.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitieService specialitieService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitieService specialitieService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitieService = specialitieService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
       
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        VetSpeciality radiology = new VetSpeciality();
        radiology.setDescription("Radiology");
        VetSpeciality radiologySaved = specialitieService.save(radiology);
        VetSpeciality surgery = new VetSpeciality();
        surgery.setDescription("Surgery");
        VetSpeciality surgerySaved = specialitieService.save(surgery);
        VetSpeciality dentistry = new VetSpeciality();
        dentistry.setDescription("Dentistry");
        VetSpeciality dentistrySaved = specialitieService.save(dentistry);

        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");
        owner.setAddress("Grid Street 21");
        owner.setCity("Foo Town");
        owner.setTelephone("123 345 567");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner);
        mikesPet.setName("Bulgur");
        mikesPet.setBirthDate(LocalDate.now());

        owner.getPets().add(mikesPet);

        ownerService.save(owner);

        Owner owner_2 = new Owner();
        owner_2.setFirstName("Billy");
        owner_2.setLastName("Brown");
        owner_2.setAddress("Grid Street 21");
        owner_2.setCity("Foo Town");
        owner_2.setTelephone("123 345 567");

        Pet billiCat = new Pet();
        billiCat.setBirthDate(LocalDate.now());
        billiCat.setOwner(owner_2);
        billiCat.setName("Niko");
        billiCat.setPetType(savedCatPetType);

        ownerService.save(owner_2);

        Vet vet = new Vet();
        vet.setFirstName("Jane");
        vet.setLastName("White");
        vet.getSpecialities().add(dentistrySaved);

        vetService.save(vet);

        Vet vet_2 = new Vet();
        vet_2.setFirstName("Jasmine");
        vet_2.setLastName("Herodes");
        vet_2.getSpecialities().add(surgerySaved);

        vetService.save(vet_2);
    }
}
