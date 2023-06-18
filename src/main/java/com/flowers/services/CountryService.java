package com.flowers.services;

import com.flowers.dtos.CommandeDto;
import com.flowers.dtos.CountryDto;
import com.flowers.models.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    CountryDto saveCountry(CountryDto countryDto);

    CountryDto updateCountry(Long countryId, CountryDto countryDto);

    CountryDto findCountryById(Long countryId);

    List<CountryDto> findAllCountries();

    List<CountryDto> findCountryByOrderByIdDesc();

    void delete(Long countryId);

    List<CountryDto> findAllActiveCountries();

    void deleteCountry(Long countryId);


}
