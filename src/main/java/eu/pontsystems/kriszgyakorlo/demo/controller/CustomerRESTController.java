package eu.pontsystems.kriszgyakorlo.demo.controller;

import eu.pontsystems.kriszgyakorlo.demo.dto.CustomerDto;
import eu.pontsystems.kriszgyakorlo.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerRESTController {
    @Autowired //why is this needed if the IDE says is not recommended?
    private CustomerService service;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> show(@PathVariable("id") Long id) {
        CustomerDto foundCustomer = service.find(id);
        if (foundCustomer == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundCustomer);
        }
    }
}
