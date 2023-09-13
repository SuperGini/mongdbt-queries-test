package com.example.mongoquerytest.repository.custom;

import com.example.mongoquerytest.model.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * https://stackoverflow.com/questions/36145229/mongodb-lookup-in-spring-data-mongo
 *https://www.baeldung.com/spring-data-mongodb-projections-aggregations
 * */
@Repository
@RequiredArgsConstructor
public class CustomCompanyRepository {

    //join 2 colectii
    private final MongoTemplate mongoTemplate;


    public Optional<Company> lookupOperation(String id) {
                //creez match stage
        var matchStage = Aggregation.match(Criteria.where("_id").is(id));
                //creez lookup stage
        var lookupStage = Aggregation.lookup()
                .from("company")
                .localField("companyId")
                .foreignField("_id")
                .as("companyData");
                //creez projection stage
        var projectStage = Aggregation.project("companyData._id", "companyData.name");
                //le combin pe toate 3
        var aggregation = Aggregation.newAggregation(matchStage, lookupStage, projectStage);

                //dau drumul la query
        var results = mongoTemplate.aggregate(aggregation, "person", Company.class)
                .getMappedResults().stream()
                .findFirst();

        return results;
    }
}

