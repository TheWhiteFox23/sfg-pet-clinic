package cz.whiterabbit.sfgpetclinic.bootstrap;

import cz.whiterabbit.sfgpetclinic.model.*;
import cz.whiterabbit.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitieService specialitieService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitieService specialitieService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitieService = specialitieService;
        this.visitService = visitService;
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

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality radiologySaved = specialitieService.save(radiology);
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality surgerySaved = specialitieService.save(surgery);
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality dentistrySaved = specialitieService.save(dentistry);

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
        owner_2.getPets().add(billiCat);
        //System.out.println("Saving Owner");
        ownerService.save(owner_2);
        //System.out.println("Pet id after save : ");
        //System.out.println("owner_2 pets size : " + owner_2.getPets().size());
        //owner_2.getPets().forEach(pet -> {System.out.println(pet.getId());});

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

        Visit visit = new Visit();
        visit.setPet(billiCat);
        visit.setDate(LocalDate.now());
        visit.setDescription("sneezy kitty");

        visitService.save(visit);
    }
}
