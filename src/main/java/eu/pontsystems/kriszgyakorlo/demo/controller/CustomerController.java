package eu.pontsystems.kriszgyakorlo.demo.controller;

import eu.pontsystems.kriszgyakorlo.demo.dto.CustomerDto;
import eu.pontsystems.kriszgyakorlo.demo.entity.Customer;
import eu.pontsystems.kriszgyakorlo.demo.repository.CustomerRepository;
import eu.pontsystems.kriszgyakorlo.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class CustomerController {
    protected CustomerRepository customerRepository;
    @Autowired
    private CustomerService service;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    } //this is a constructor, connect the controller to the repo. ( Bigger projects should use a sevice between these layers)

    @GetMapping("/customers")
    public String listCustomers(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                @RequestParam(name = "pagesize", required = false, defaultValue = "10") Integer pagesize,
                                Model model) {

        Page<CustomerDto> customerPage = service.list(page, pagesize);
        model.addAttribute("customerPage", customerPage);

        int totalPages = customerPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "customer/list";
    }

    @GetMapping("/customer/create")
    public String ShowCreateForm(Customer customer) {
        return "customer/create";
    }

    @PostMapping("/customer/create")
    public String CreateCustomer(@Valid CustomerDto customerDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "customer/create";
        }

        service.save(customerDto);
        return "redirect:/customers";
    }

    @GetMapping("/customer/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        CustomerDto customerDto = service.find(id);
        // .orElseThrow(() -> new IllegalArgumentException(" Invalid user Id: " + id));  // TODO: why these are cannot accessed?

        model.addAttribute("customer", customerDto);
        return "customer/update";
    }

    @PostMapping("/customer/update/{id}")
    public String updateCustomer(@Valid CustomerDto customerDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "customer/update";
        }
        service.save(customerDto);
        return "redirect:/customers";
    }

    @GetMapping("customer/delete/{id}")
    public String deleteCustomer(@PathVariable("id") long id, Model model) {
        CustomerDto customerDto = service.find(id);
        //  .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        service.delete(customerDto);
        return "redirect:/customers";
    }

}
