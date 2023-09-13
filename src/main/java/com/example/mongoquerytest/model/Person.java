package com.example.mongoquerytest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "person")
public class Person {

    @Id
    private String id;
    private String name;
    private Address address;
    private String companyId;

}
