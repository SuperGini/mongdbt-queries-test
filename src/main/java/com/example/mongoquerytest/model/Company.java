package com.example.mongoquerytest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "company")
public class Company {

    @Id
    private String id;
    private String name;



}
