package com.bursu.springmongo;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final MongoTemplate template;

    public CustomerService(CustomerRepository repository, MongoTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = repository.findByFirstName(customer.getFirstName());
        if (null != existingCustomer) {
           return repository.save(customer);
        }

        throw new RuntimeException();
    }
}
