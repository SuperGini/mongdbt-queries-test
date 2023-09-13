package com.example.mongoquerytest.repository;

import com.example.mongoquerytest.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, String> {

    @Query("""
                {'id':  ?0}
            """)
    Optional<Person> findPersonById(String personId);

//    @Query("""
//
//            """)
//    Optional<Person> fondPersonByCompanyId(String companyId);

}
