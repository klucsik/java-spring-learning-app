package eu.pontsystems.kriszgyakorlo.demo.service;

import eu.pontsystems.kriszgyakorlo.demo.dto.ProductDto;
import eu.pontsystems.kriszgyakorlo.demo.entity.Product;
import eu.pontsystems.kriszgyakorlo.demo.mapper.ProductMapper;
import eu.pontsystems.kriszgyakorlo.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    ProductRepository productRepository;

    public ProductDto find(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(" Invalid user Id: " + id));
        ProductDto productDto = ProductMapper.INSTANCE.productToDto(product);
        return productDto;
    }

}
