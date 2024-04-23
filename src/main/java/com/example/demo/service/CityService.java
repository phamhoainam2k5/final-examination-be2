package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService{

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRepository.findCityById(id);
    }

    @Override
    public City createdCity(City city) {
        City savedCity = cityRepository.save(city);
        return savedCity;
    }

    @Override
    public City updatedCity(Long id, City updatedCity) {
        City city = cityRepository.findCityById(id);

        city.setNameCity(updatedCity.getNameCity());
        city.setQuocgia(updatedCity.getQuocgia());
        city.setS(updatedCity.getS());
        city.setPeopleCity(updatedCity.getPeopleCity());
        city.setGdp(updatedCity.getGdp());
        city.setDescription(updatedCity.getDescription());

        City updatedCityObj = cityRepository.save(city);

        return updatedCityObj;
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }


}
