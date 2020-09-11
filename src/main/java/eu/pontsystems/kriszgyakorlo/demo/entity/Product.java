package eu.pontsystems.kriszgyakorlo.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "productname cannot be blank")
    private String name;
    @PositiveOrZero(message = "Price must be positive")
    private Integer price;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;

    @ManyToOne
    private Customer customer;

    public Product(String name, Integer price) {
        this.name=name;
        this.price=price;
    }

    public Product(String name, Integer price, Customer customer) {
        this.name=name;
        this.price=price;
        this.customer=customer;
    }

    public String toString(){
        return String.format("Product[id=%d, Name='%s', Price='%s']", id, name, price);
    }
}
