package com.carmangement.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.carmangement.model.Car;
import com.carmangement.service.CarService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { 
    RequestMethod.GET, 
    RequestMethod.POST, 
    RequestMethod.PUT, 
    RequestMethod.DELETE, 
    RequestMethod.OPTIONS 
})
    
@RestController

@RequestMapping("/api/v1/cars")


public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public Car addCar(@Valid @RequestBody Car car) {
        return carService.addCar(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/paginated")
    public Page<Car> getCars(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return carService.getCars(pageable);
    }

    @GetMapping("/search")
    public List<Car> searchCars(@RequestParam String keyword) {
        return carService.searchCars(keyword);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @Valid @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}

