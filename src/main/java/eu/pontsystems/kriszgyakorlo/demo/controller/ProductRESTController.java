package eu.pontsystems.kriszgyakorlo.demo.controller;

import eu.pontsystems.kriszgyakorlo.demo.dto.CustomerDto;
import eu.pontsystems.kriszgyakorlo.demo.dto.ProductDto;
import eu.pontsystems.kriszgyakorlo.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductRESTController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> show(@PathVariable("id") Long id) {
        ProductDto foundProduct = service.find(id);
        if (foundProduct == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundProduct);
        }
    }

}
