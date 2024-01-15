package com.bursu.springmongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OwnerRepository extends MongoRepository<Owner, String> {


}