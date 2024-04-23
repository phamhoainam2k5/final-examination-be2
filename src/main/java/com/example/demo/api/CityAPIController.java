package com.example.demo.api;

import com.example.demo.model.City;
import com.example.demo.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityAPIController {

    @Autowired
    private ICityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") Long id) {
        City city = cityService.getCityById(id);
        return ResponseEntity.ok(city);
    }

    @PostMapping
    public ResponseEntity<City> savedCity(@RequestBody City city) {
        if (city.getNameCity() == null || city.getNameCity().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (city.getQuocgia() == null || city.getQuocgia().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (city.getS() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (city.getPeopleCity() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (city.getGdp() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (city.getDescription() == null || city.getDescription().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        City savedCity = cityService.createdCity(city);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<City> updatedCity(@PathVariable("id") Long id,@RequestBody City city) {
        if (city.getNameCity() == null || city.getNameCity().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (city.getQuocgia() == null || city.getQuocgia().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (city.getS() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (city.getPeopleCity() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (city.getGdp() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (city.getDescription() == null || city.getDescription().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        City updatedCity = cityService.updatedCity(id, city);
        return ResponseEntity.ok(updatedCity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.ok("City deleted successfully!");
    }
}
