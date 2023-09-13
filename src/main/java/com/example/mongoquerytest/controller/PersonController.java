package com.example.mongoquerytest.controller;

import com.example.mongoquerytest.model.Person;
import com.example.mongoquerytest.repository.custom.CustomCompanyRepository;
import com.example.mongoquerytest.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonService personService;
    private final CustomCompanyRepository customRepository;


    @PostMapping("/person")
    @ResponseStatus(HttpStatus.OK)
    public Person savePerson(@RequestBody Person person){
       return personService.save(person);
    }

    @GetMapping("/person/{id}")
    public Person ddd(@PathVariable String id){
        return personService.findById(id);
    }


}
