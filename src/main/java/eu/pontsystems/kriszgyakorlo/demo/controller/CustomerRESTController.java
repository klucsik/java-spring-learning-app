package eu.pontsystems.kriszgyakorlo.demo.controller;

import eu.pontsystems.kriszgyakorlo.demo.dto.CustomerDto;
import eu.pontsystems.kriszgyakorlo.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("")
    public ResponseEntity<Page<CustomerDto>> list(
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "pagesize", required = false, defaultValue = "10") Integer pagesize
    ) {
        Page<CustomerDto> customerPage = service.list(page, pagesize);
        if (customerPage == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(customerPage);
        }
    }

}
