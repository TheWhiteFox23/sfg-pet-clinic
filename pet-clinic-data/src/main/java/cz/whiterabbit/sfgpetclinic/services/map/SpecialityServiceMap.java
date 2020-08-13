package cz.whiterabbit.sfgpetclinic.services.map;

import cz.whiterabbit.sfgpetclinic.model.VetSpeciality;
import cz.whiterabbit.sfgpetclinic.services.SpecialitiesService;

import java.util.Set;

public class SpecialityServiceMap extends AbstractMapService<VetSpeciality, Long> implements SpecialitiesService {
    @Override
    public Set<VetSpeciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public VetSpeciality save(VetSpeciality object) {
        return super.save(object);
    }

    @Override
    public void delete(VetSpeciality object) {
        super.delete(object);
    }

    @Override
    public VetSpeciality findById(Long id) {
        return super.findById(id);
    }
}
