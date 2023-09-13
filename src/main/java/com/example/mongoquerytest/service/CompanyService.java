package com.example.mongoquerytest.service;

import com.example.mongoquerytest.model.Company;
import com.example.mongoquerytest.repository.CompanyRepository;
import com.example.mongoquerytest.repository.custom.CustomCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CustomCompanyRepository customRepository;

    public Company saveCompany(Company company) {
        company.setId(UUID.randomUUID().toString());
        return companyRepository.save(company);
    }

    public Company getCompanyByPersonId(String id){
        return customRepository.lookupOperation(id)
                                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

}
