package com.flowers.services;

import com.flowers.models.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Country saveCountry(Country country);

    Country updateCountry(Long countryId, Country country);

    Optional<Country> findCountryById(Long countryId);

    Country findByCode(String code);

    Country findByDesignation(String designation);

    List<Country> findAllCountries();

    void deleteCountry(Long countryId);

    List<Country> ListCountryByCode(String designation);

    List<Country> ListCountryByDesignation(String designation);


}
