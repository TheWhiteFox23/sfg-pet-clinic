package cz.whiterabbit.sfgpetclinic.bootstrap;

import cz.whiterabbit.sfgpetclinic.model.Owner;
import cz.whiterabbit.sfgpetclinic.model.Vet;
import cz.whiterabbit.sfgpetclinic.services.OwnerService;
import cz.whiterabbit.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");

        ownerService.save(owner);

        Owner owner_2 = new Owner();
        owner_2.setFirstName("Billy");
        owner_2.setLastName("Brown");

        ownerService.save(owner_2);

        Vet vet = new Vet();
        vet.setFirstName("Jane");
        vet.setLastName("White");

        vetService.save(vet);

        Vet vet_2 = new Vet();
        vet_2.setFirstName("Jasmine");
        vet_2.setLastName("Herodes");

        vetService.save(vet_2);

    }
}
