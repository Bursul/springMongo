package com.bursu.springmongo.changelogs;

import com.bursu.springmongo.Customer;
import com.bursu.springmongo.CustomerRepository;
import io.mongock.api.annotations.BeforeExecution;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackBeforeExecution;
import io.mongock.api.annotations.RollbackExecution;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id="customer-initializer", order = "1", author = "mongock")
public class CustomerInitializerChangeUnit {

    public final static int INITIAL_CLIENTS = 10;
    public final static String CUSTOMER_COLLECTION_NAME = "customerCollection";
    @BeforeExecution
    public void beforeExecution(MongoTemplate mongoTemplate) {

        mongoTemplate.createCollection(CUSTOMER_COLLECTION_NAME);
    }

    @RollbackBeforeExecution
    public void rollbackBeforeExecution(MongoTemplate mongoTemplate) {

        mongoTemplate.dropCollection(CUSTOMER_COLLECTION_NAME);
    }

    @Execution
    public void execution(CustomerRepository customerRepository) {

        customerRepository.saveAll(
                IntStream.range(0, INITIAL_CLIENTS)
                        .mapToObj(CustomerInitializerChangeUnit::getCustomer)
                        .collect(Collectors.toList())
        );
    }

    @RollbackExecution
    public void rollbackExecution(CustomerRepository customerRepository) {

        customerRepository.deleteAll();
    }

    private static Customer getCustomer(int i) {
        return new Customer("firstName-" + i, "lastName" + i);
    }
}