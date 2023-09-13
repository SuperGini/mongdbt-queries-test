package com.example.mongoquerytest.service;

import com.example.mongoquerytest.model.Person;
import com.example.mongoquerytest.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;



    public Person save(Person person) {
        person.setId(UUID.randomUUID().toString());
        return personRepository.save(person);
    }

    public Person findById(String personId){
        return personRepository.findPersonById(personId)
                .orElseThrow(() -> new RuntimeException("Nu l-am gasit bosss"));
    }

}
