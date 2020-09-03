package eu.pontsystems.kriszgyakorlo.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message="Firstname cannot be blank")
    private String firstName;
    private String lastName;

    protected Customer(){}; // The default constructor exists only for the sake of JPA. You do not use it directly, so it is designated as protected.

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName= lastName;
    }

    @Override
    public String toString(){
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']",id,firstName,lastName);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
