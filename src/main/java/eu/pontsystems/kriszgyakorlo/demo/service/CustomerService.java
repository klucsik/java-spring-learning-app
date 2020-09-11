package eu.pontsystems.kriszgyakorlo.demo.service;

import eu.pontsystems.kriszgyakorlo.demo.dto.CustomerDto;
import eu.pontsystems.kriszgyakorlo.demo.entity.Customer;
import eu.pontsystems.kriszgyakorlo.demo.mapper.CustomerMapper;
import eu.pontsystems.kriszgyakorlo.demo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    protected CustomerRepository customerRepository;

    public CustomerDto find(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(" Invalid user Id: " + id));
        CustomerDto customerDto = CustomerMapper.INSTANCE.customerToDto(customer);
        return customerDto;
    }

    public Page<CustomerDto> list(Integer pageNumber, Integer pageSize) {
        Pageable pageparams = PageRequest.of(pageNumber - 1, pageSize); //shift the numbering start from 0 to 1 for humanreadable
        Page<Customer> customerPage = customerRepository.findAll(pageparams);
        return customerPage.map(CustomerMapper.INSTANCE::customerToDto);
    }

    public void save(CustomerDto customerDto) {
        Customer customer = CustomerMapper.INSTANCE.dtoToCustomer(customerDto);
        customerRepository.save(customer);
    }

    public void delete(CustomerDto customerDto) {
        Customer customer = CustomerMapper.INSTANCE.dtoToCustomer(customerDto);
        customerRepository.delete(customer);
    }
}
