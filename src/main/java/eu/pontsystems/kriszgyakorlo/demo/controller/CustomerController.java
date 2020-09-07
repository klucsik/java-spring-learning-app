package eu.pontsystems.kriszgyakorlo.demo.controller;

import eu.pontsystems.kriszgyakorlo.demo.entity.Customer;
import eu.pontsystems.kriszgyakorlo.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    } //this is a constructor, connect the controller to the repo. ( Bigger projects should use a sevice between these layers)

    @GetMapping("/customers")
    public String listCustomers(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                @RequestParam(name = "pagesize", required = false, defaultValue = "10") Integer pagesize,
                                Model model) {
        Pageable pageparams = PageRequest.of(page - 1, pagesize); //shift the numbering start from 0 to 1 for humanreadable
        Page<Customer> customerPage = customerRepository.findAll(pageparams);
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
    public String CreateCustomer(@Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "customer/create";
        }

        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll()); // TODO: this is needed for the redirect context?
        return "redirect:/customers";
    }

    @GetMapping("/customer/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Customer customer = customerRepository.findById(id);
        // .orElseThrow(() -> new IllegalArgumentException(" Invalid user Id: " + id));  // TODO: why these are cannot accessed?

        model.addAttribute("customer", customer);
        return "customer/update";
    }

    @PostMapping("/customer/update/{id}")
    public String updateCustomer(@Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "customer/update";
        }

        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "redirect:/customers";
    }

    @GetMapping("customer/delete/{id}")
    public String deleteCustomer(@PathVariable("id") long id, Model model) {
        Customer customer = customerRepository.findById(id);
        //  .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        customerRepository.delete(customer);
        model.addAttribute("users", customerRepository.findAll());
        return "redirect:/customers";
    }

}
