package com.carmangement.service;


import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.carmangement.model.Car;
import com.carmangement.repository.CarRepository;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Page<Car> getCars(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    public List<Car> searchCars(String keyword) {
        return carRepository.findAll((root, query, cb) -> {
            Predicate nameMatch = cb.like(root.get("name"), "%" + keyword + "%");
            Predicate modelMatch = cb.like(root.get("model"), "%" + keyword + "%");
            Predicate yearMatch = cb.like(root.get("year").as(String.class), "%" + keyword + "%");
            Predicate colorMatch = cb.like(root.get("color"), "%" + keyword + "%");
            Predicate fuelTypeMatch = cb.like(root.get("fuelType"), "%" + keyword + "%");
            return cb.or(nameMatch, modelMatch, yearMatch, colorMatch, fuelTypeMatch);
        });
    }

    public Car updateCar(Long id, Car carDetails) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        car.setName(carDetails.getName());
        car.setModel(carDetails.getModel());
        car.setYear(carDetails.getYear());
        car.setPrice(carDetails.getPrice());
        car.setColor(carDetails.getColor());
        car.setFuelType(carDetails.getFuelType());
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}