package com.bursu.springmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {


    CustomerRepository customerRepository;
    OwnerRepository ownerRepository;
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, OwnerRepository ownerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.ownerRepository = ownerRepository;
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer _customer = customerRepository.save(customer);
            return new ResponseEntity<>(_customer, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        try {
            Customer _customer = customerService.updateCustomer(customer);
            return new ResponseEntity<>(_customer, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }



    @PostMapping("/addOwner")
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        try {
            Owner _owner = ownerRepository.save(owner);
            return new ResponseEntity<>(_owner, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
