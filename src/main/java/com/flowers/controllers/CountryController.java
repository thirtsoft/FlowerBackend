package com.flowers.controllers;

import com.flowers.controllers.api.CountryApi;
import com.flowers.models.Country;
import com.flowers.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CountryController implements CountryApi {

    private final CountryService countryService;

    @Override
    public ResponseEntity<Country> saveCountry(Country Country) {
        return null;
    }

    @Override
    public ResponseEntity<Country> updateCountry(Long catId, Country Country) {
        return null;
    }

    @Override
    public ResponseEntity<Country> findCountryById(Long catId) {
        return null;
    }

    @Override
    public ResponseEntity<Country> findByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<Country> findByDesignation(String designation) {
        return null;
    }

    @Override
    public ResponseEntity<List<Country>> getAllCountries() {
        return null;
    }

    @Override
    public ResponseEntity<List<Country>> getListCountriesByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<List<Country>> getListCountriesByDesignation(String designation) {
        return null;
    }

    @Override
    public void deleteCountry(Long catId) {

    }
}
