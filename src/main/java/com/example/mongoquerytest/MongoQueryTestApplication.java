package com.example.mongoquerytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.example")
@SpringBootApplication
public class MongoQueryTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoQueryTestApplication.class, args);
    }

}
