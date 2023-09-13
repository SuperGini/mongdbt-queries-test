package com.example.mongoquerytest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "phone")
public class Phone {

    @Id
    private String id;
    private String companyPhone;
    private String companyId;

}
