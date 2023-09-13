package com.example.mongoquerytest.controller;

import com.example.mongoquerytest.dto.PhoneResponse;
import com.example.mongoquerytest.model.Phone;
import com.example.mongoquerytest.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PhoneController {


    public final PhoneService phoneService;

    @PostMapping("/phone")
    @ResponseStatus(HttpStatus.OK)
    public Phone save(@RequestBody Phone phone) {
        return phoneService.save(phone);
    }

    @GetMapping("/phone/{personId}")
    @ResponseStatus(HttpStatus.OK)
    public List<PhoneResponse> getPhones(@PathVariable String personId){
       return phoneService.getCompanyPhones(personId);
    }


}
