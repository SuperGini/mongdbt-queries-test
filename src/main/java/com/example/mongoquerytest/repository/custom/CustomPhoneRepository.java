package com.example.mongoquerytest.repository.custom;

import com.example.mongoquerytest.dto.PhoneResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class CustomPhoneRepository {

        //join 3 colectii
    private final MongoTemplate mongoTemplate;


    public List<PhoneResponse> getCompanyPhones(String personId) {
        var matchStage = Aggregation.match(Criteria.where("_id").is(personId));

        var lookupStage = Aggregation.lookup()
                .from("company")
                .localField("companyId")
                .foreignField("_id")
                .as("companyData");

        var unwindStage = Aggregation.unwind("$companyData");

        var lookupSatege2 = Aggregation.lookup()
                .from("phone")
                .localField("companyData._id")
                .foreignField("companyId")
                .as("phoneData");

        var unwindStage2 = Aggregation.unwind("$phoneData");

        var projectionStage = Aggregation.project("$phoneData._id", "$phoneData.companyPhone", "$phoneData.companyId");

        var aggregation = Aggregation.newAggregation(
                                                                matchStage,
                                                                lookupStage,
                                                                unwindStage,
                                                                lookupSatege2,
                                                                unwindStage2,
                                                                projectionStage
        );


        var result = mongoTemplate.aggregate(aggregation, "person", PhoneResponse.class)
                .getMappedResults();

        return result;

    }

}
