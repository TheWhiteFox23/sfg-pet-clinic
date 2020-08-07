package cz.whiterabbit.sfgpetclinic.model;

public class Person extends BaseEntity{
    private String firstName;
    private String lastName;

    //TODO extends entity
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
