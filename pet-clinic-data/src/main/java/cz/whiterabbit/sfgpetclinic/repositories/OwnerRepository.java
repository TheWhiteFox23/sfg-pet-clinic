package cz.whiterabbit.sfgpetclinic.repositories;

import cz.whiterabbit.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
