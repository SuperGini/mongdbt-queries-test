package com.example.mongoquerytest.service;

import com.example.mongoquerytest.model.Car;
import com.example.mongoquerytest.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;

    public Car save(Car car) {
        car.setId(UUID.randomUUID().toString());
        return carRepository.save(car);
    }
}
