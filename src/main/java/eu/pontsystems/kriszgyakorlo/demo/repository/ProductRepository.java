package eu.pontsystems.kriszgyakorlo.demo.repository;

import eu.pontsystems.kriszgyakorlo.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
