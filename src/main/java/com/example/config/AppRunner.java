package com.example.config;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();
        personRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Smith"));

        System.out.println("Customers found with findAll \n --------------");
        customerRepository.findAll().forEach(System.out::println);

        System.out.println("\n Customer found by findByFirstName 'Alice'");
        System.out.println(customerRepository.findByFirstName("Alice"));

        System.out.println("\n Customers found by lastname 'Smith'");
        customerRepository.findByLastName("Smith").forEach(System.out::println);
    }
}
