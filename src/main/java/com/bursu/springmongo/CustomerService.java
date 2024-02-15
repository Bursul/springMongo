package com.bursu.springmongo;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = repository.findByFirstName(customer.getFirstName());
        if (null != existingCustomer) {
           return repository.save(customer);
        }

        throw new RuntimeException();
    }
}
