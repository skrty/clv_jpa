package hello.rest;

import hello.entity.Car;
import hello.entity.CarManufacturer;
import hello.entity.Color;
import hello.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by skrty on 25.7.2017.
 */
@RestController
public class CarController {
    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public Iterable<Car> getAllCar() {
        return carRepository.findAll();
    }

    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable(name = "id") Long id) {
        return carRepository.findOne(id);
    }

    @PostMapping("/car")
    public String insertCar(@RequestBody Car car) {
        carRepository.save(car);
        return "Car inserted!";
    }

    @DeleteMapping("/car/{id}")
    public Boolean deleteCar(@PathVariable(name = "id") Long id) {
        try {
            if (!carRepository.exists(id)) {
                return Boolean.FALSE;
            }
            carRepository.delete(id);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
