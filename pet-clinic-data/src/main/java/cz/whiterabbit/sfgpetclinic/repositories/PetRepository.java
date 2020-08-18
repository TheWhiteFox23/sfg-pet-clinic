package cz.whiterabbit.sfgpetclinic.repositories;

import cz.whiterabbit.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository  extends CrudRepository<Pet,Long> {
}
