package cz.whiterabbit.sfgpetclinic.services.map;

import cz.whiterabbit.sfgpetclinic.model.Pet;
import cz.whiterabbit.sfgpetclinic.services.CrudService;
import cz.whiterabbit.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"mapservice", "default"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        //object.getOwner().getPets().add(object);
        super.save(object);
        return object;
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
