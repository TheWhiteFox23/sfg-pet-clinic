package cz.whiterabbit.sfgpetclinic.services.map;

import cz.whiterabbit.sfgpetclinic.model.Vet;
import cz.whiterabbit.sfgpetclinic.model.Speciality;
import cz.whiterabbit.sfgpetclinic.services.SpecialitieService;
import cz.whiterabbit.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"mapservice", "default"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

    private final SpecialitieService specialitieService;

    public VetServiceMap(SpecialitieService specialitieService) {
        this.specialitieService = specialitieService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(vetSpeciality -> {
                if(vetSpeciality.getId() == null){
                    Speciality savedSpeciality = specialitieService.save(vetSpeciality);
                    vetSpeciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
