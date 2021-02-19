package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Smith"));

        System.out.println("Customers found with findAll \n --------------");
        customerRepository.findAll().stream().forEach(System.out::println);

        System.out.println("\n Customer found by findByFirstName 'Alice'");
        System.out.println(customerRepository.findByFirstName("Alice"));

        System.out.println("\n Customers found by lastname 'Smith'");
        customerRepository.findByLastName("Smith").stream().forEach(System.out::println);
    }
}
