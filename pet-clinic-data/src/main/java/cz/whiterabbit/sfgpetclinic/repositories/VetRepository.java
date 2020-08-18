package cz.whiterabbit.sfgpetclinic.repositories;

import cz.whiterabbit.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository  extends CrudRepository<Vet, Long> {
}
