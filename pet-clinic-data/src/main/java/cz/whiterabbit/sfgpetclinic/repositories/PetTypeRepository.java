package cz.whiterabbit.sfgpetclinic.repositories;

import cz.whiterabbit.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository  extends CrudRepository<PetType, Long> {
}
