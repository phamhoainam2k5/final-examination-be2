package com.example.demo.service;

import com.example.demo.model.City;

import java.util.List;

public interface ICityService {
    List<City> getAllCities();

    City getCityById(Long id);

    City createdCity(City savedCity);

    City updatedCity(Long id, City updatedCity);

    void deleteCity(Long id);
}
