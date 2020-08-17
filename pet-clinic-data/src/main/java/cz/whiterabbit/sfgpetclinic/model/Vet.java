package cz.whiterabbit.sfgpetclinic.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<VetSpeciality> specialities = new HashSet<>();

    public Set<VetSpeciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<VetSpeciality> specialities) {
        this.specialities = specialities;
    }
}
