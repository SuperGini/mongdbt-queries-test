package com.example.mongoquerytest.controller;

import com.example.mongoquerytest.model.Company;
import com.example.mongoquerytest.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/company")
    @ResponseStatus(HttpStatus.OK)
    public Company saveCompany(@RequestBody Company company){
        return companyService.saveCompany(company);
    }

    @GetMapping("/company/{personId}")
    public Company findByPersonId(@PathVariable String personId){
      return  companyService.getCompanyByPersonId(personId);
    }


}
