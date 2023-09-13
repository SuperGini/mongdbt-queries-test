package com.example.mongoquerytest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;


@Getter
@Setter
@Document(collection = "car")
public class Car {

    @Id
    private String id;
    private String manufacturer;
    @CreatedDate
    private OffsetDateTime created;
    private String companyId;
    private String personId;

}
