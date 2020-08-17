package cz.whiterabbit.sfgpetclinic.model;

import javax.persistence.*;

@Entity
@Table(name = "types")
public class PetType extends BaseEntity{

    @Column(name = "name")
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
