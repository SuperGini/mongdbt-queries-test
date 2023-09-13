package com.example.mongoquerytest.controller;

import com.example.mongoquerytest.model.Car;
import com.example.mongoquerytest.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarController {

    private final CarService carService;

    @PostMapping("/car")
    public Car saveCar(@RequestBody Car car){
        return carService.save(car);
    }
}
