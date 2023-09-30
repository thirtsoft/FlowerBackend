package com.flowers.services;

import com.flowers.dtos.CountryDto;

import java.util.List;

public interface CountryService {

    CountryDto saveCountry(CountryDto countryDto);

    CountryDto updateCountry(Long countryId, CountryDto countryDto);

    CountryDto findCountryById(Long countryId);

    List<CountryDto> findAllActiveCountries();

    void deleteCountry(Long countryId);


}
