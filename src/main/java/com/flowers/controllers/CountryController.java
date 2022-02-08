package com.flowers.controllers;

import com.flowers.controllers.api.CountryApi;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Country;
import com.flowers.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CountryController implements CountryApi {

    private final CountryService countryService;


    @Override
    public ResponseEntity<Country> saveCountry(Country country) {
        return ResponseEntity.ok(countryService.saveCountry(country));
    }

    @Override
    public ResponseEntity<Country> updateCountry(Long countId, Country country) {
        country.setId(countId);
        return ResponseEntity.ok(countryService.saveCountry(country));
    }

    @Override
    public ResponseEntity<Country> getCountryById(Long countId) throws ResourceNotFoundException {
        Country country = countryService.findCountryById(countId)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found"));
        return ResponseEntity.ok().body(country);
    }

    @Override
    public ResponseEntity<List<Country>> getAllCountries() {
        return ResponseEntity.ok(countryService.findAllCountries());
    }

    @Override
    public ResponseEntity<List<Country>> getAllCountriesOderByIdDesc() {
        List<Country> countryList = countryService.findCountryByOrderByIdDesc();
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }

    @Override
    public void deleteCountry(Long countId) {
        countryService.deleteCountry(countId);
    }
}
