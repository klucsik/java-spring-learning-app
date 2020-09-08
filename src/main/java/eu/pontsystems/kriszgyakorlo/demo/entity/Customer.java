package eu.pontsystems.kriszgyakorlo.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Firstname cannot be blank")
    private String firstName;
    private String lastName;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    // The default constructor exists only for the sake of JPA. You do not use it directly, so it is designated as protected.
    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;

    protected Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
    }

}
