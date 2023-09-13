package com.example.mongoquerytest.service;

import com.example.mongoquerytest.dto.PhoneResponse;
import com.example.mongoquerytest.model.Phone;
import com.example.mongoquerytest.repository.PhoneRepository;
import com.example.mongoquerytest.repository.custom.CustomPhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final CustomPhoneRepository customPhoneRepository;


    public Phone save(Phone phone) {
        phone.setId(UUID.randomUUID().toString());
        return phoneRepository.save(phone);
    }

    public List<PhoneResponse> getCompanyPhones(String personId) {
        return customPhoneRepository.getCompanyPhones(personId);
    }

}
