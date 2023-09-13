package com.example.mongoquerytest.repository;

import com.example.mongoquerytest.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {
}
