package eu.pontsystems.kriszgyakorlo.demo;

import eu.pontsystems.kriszgyakorlo.demo.entity.Customer;
import eu.pontsystems.kriszgyakorlo.demo.entity.Product;
import eu.pontsystems.kriszgyakorlo.demo.repository.CustomerRepository;
import eu.pontsystems.kriszgyakorlo.demo.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RestController
public class DemoApplication {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository, ProductRepository productRepository) {
        return (args) -> {
            // save a few customers
            customerRepository.save(new Customer("Jack", "Bauer"));
            customerRepository.save(new Customer("Chloe", "O'Brian"));
            customerRepository.save(new Customer("Kim", "Bauer"));
            customerRepository.save(new Customer("David", "Palmer"));
            customerRepository.save(new Customer("Michelle", "Dessler"));
            customerRepository.save(new Customer("1Jack", "Bauer"));
            customerRepository.save(new Customer("1Chloe", "O'Brian"));
            customerRepository.save(new Customer("1Kim", "Bauer"));
            customerRepository.save(new Customer("1David", "Palmer"));
            customerRepository.save(new Customer("1Michelle", "Dessler"));
            customerRepository.save(new Customer("2Jack", "Bauer"));
            customerRepository.save(new Customer("2Chloe", "O'Brian"));
            customerRepository.save(new Customer("2Kim", "Bauer"));
            customerRepository.save(new Customer("2David", "Palmer"));
            customerRepository.save(new Customer("2Michelle", "Dessler"));
            customerRepository.save(new Customer("3Jack", "Bauer"));
            customerRepository.save(new Customer("3Chloe", "O'Brian"));
            customerRepository.save(new Customer("3Kim", "Bauer"));
            customerRepository.save(new Customer("3David", "Palmer"));
            customerRepository.save(new Customer("3Michelle", "Dessler"));
            customerRepository.save(new Customer("4Jack", "Bauer"));
            customerRepository.save(new Customer("4Chloe", "O'Brian"));
            customerRepository.save(new Customer("4Kim", "Bauer"));
            customerRepository.save(new Customer("4David", "Palmer"));
            customerRepository.save(new Customer("4Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : customerRepository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            productRepository.save(new Product("Alma",0));
            productRepository.save(new Product("Körte",100));
            productRepository.save(new Product("Pari",1000));

            // fetch all product
            log.info("Product found with findAll():");
            log.info("-------------------------------");
            for (Product product : productRepository.findAll()) {
                log.info(product.toString());
            }
            log.info("");
        };
    }
}
