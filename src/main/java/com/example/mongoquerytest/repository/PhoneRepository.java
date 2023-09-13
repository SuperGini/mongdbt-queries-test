package com.example.mongoquerytest.repository;

import com.example.mongoquerytest.model.Phone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhoneRepository extends MongoRepository<Phone, String> {
}
