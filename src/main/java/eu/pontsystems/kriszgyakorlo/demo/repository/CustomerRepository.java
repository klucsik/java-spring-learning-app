package eu.pontsystems.kriszgyakorlo.demo.repository;

import java.util.List;

import eu.pontsystems.kriszgyakorlo.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
