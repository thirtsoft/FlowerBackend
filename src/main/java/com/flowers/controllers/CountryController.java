package com.flowers.controllers;

import com.flowers.controllers.api.CountryApi;
import com.flowers.dtos.CountryDto;
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
    public ResponseEntity<CountryDto> saveCountry(CountryDto countryDto) {
        return null;
    }

    @Override
    public ResponseEntity<CountryDto> updateCountry(Long countId, CountryDto countryDto) {
        return null;
    }

    @Override
    public ResponseEntity<CountryDto> getCountryById(Long countId) {
        return null;
    }

    @Override
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        return null;
    }

    @Override
    public ResponseEntity<List<CountryDto>> getAllCountriesOderByIdDesc() {
        return null;
    }

    @Override
    public void deleteCountry(Long countId) {

    }
}
