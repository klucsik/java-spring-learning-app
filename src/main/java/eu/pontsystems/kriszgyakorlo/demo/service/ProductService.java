package eu.pontsystems.kriszgyakorlo.demo.service;

import eu.pontsystems.kriszgyakorlo.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    ProductRepository productRepository;


}
