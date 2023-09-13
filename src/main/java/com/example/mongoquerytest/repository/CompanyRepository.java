package com.example.mongoquerytest.repository;

import com.example.mongoquerytest.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {
}
