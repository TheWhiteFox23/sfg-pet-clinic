package cz.whiterabbit.sfgpetclinic.services.map;

import cz.whiterabbit.sfgpetclinic.model.Owner;
import cz.whiterabbit.sfgpetclinic.model.Pet;
import cz.whiterabbit.sfgpetclinic.services.OwnerService;
import cz.whiterabbit.sfgpetclinic.services.PetService;
import cz.whiterabbit.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"mapservice", "default"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        //Owner ownerSaved = null;
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet ->{
                    if(pet.getPetType() != null){
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }else{
                        throw new RuntimeException("Pet Type is Required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                        System.out.println("pet id : " + pet.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }

    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
