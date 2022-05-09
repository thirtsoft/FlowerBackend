package com.flowers.controllers;

import com.flowers.controllers.api.CountryApi;
import com.flowers.dtos.CountryDto;
import com.flowers.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class CountryController implements CountryApi {

    private final CountryService countryService;


    @Override
    public ResponseEntity<CountryDto> saveCountry(CountryDto countryDto) {
        CountryDto countryDtoResult = countryService.saveCountry(countryDto);
        return new ResponseEntity<>(countryDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CountryDto> updateCountry(Long countId, CountryDto countryDto) {
        countryDto.setId(countId);
        CountryDto countryDtoResult = countryService.saveCountry(countryDto);

        return new ResponseEntity<>(countryDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CountryDto> getCountryById(Long countId) {
        CountryDto countryDtoResult = countryService.findCountryById(countId);
        return new ResponseEntity<>(countryDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        List<CountryDto> countryDtoList = countryService.findAllCountries();
        return new ResponseEntity<>(countryDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CountryDto>> getAllCountriesOderByIdDesc() {
        List<CountryDto> countryDtoList = countryService.findCountryByOrderByIdDesc();
        return new ResponseEntity<>(countryDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteCountry(Long countId) {
        countryService.deleteCountry(countId);
    }
}
