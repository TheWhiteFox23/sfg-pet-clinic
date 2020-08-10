package cz.whiterabbit.sfgpetclinic.services;

import cz.whiterabbit.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
