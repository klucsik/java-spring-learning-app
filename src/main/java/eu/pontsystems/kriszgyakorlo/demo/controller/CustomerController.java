package eu.pontsystems.kriszgyakorlo.demo.controller;

import eu.pontsystems.kriszgyakorlo.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CustomerController {
    protected CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    } //what is this part? the listing is working because of this, I have no idea why

    @GetMapping("/customers")
    public String list_customers(Model model) {

        model.addAttribute("customers", customerRepository.findAll());
        return "customer/list";
    }
}
