package eu.pontsystems.kriszgyakorlo.demo.repository;

import java.util.List;

import eu.pontsystems.kriszgyakorlo.demo.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
