package com.bhutcars.application.resources;

import entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import repositories.CarRepository;

@RestController
@RequestMapping("/api")
public class CarController {

     @Autowired
     CarRepository carRepository;

    @GetMapping(value = "/listCars")
    public ResponseEntity<Car> getCars() {
        String uri = "http://api-test.bhut.com.br:3000/api/cars";
        RestTemplate restTemplate = new RestTemplate();
        Car result = restTemplate.getForObject(uri, Car.class);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/createCar") // utilizar repository para persistir dados
    public ResponseEntity<Car> createCars(@RequestBody Car car) {
        Car newCar = carRepository.save(car);
        return ResponseEntity.ok().body(newCar);

    }


}
