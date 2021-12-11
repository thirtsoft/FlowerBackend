package com.flowers.services;

import com.flowers.models.Category;
import com.flowers.models.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Country saveCountry(Country country);

    Country updateCountry(Long countryId, Country country);

    Optional<Country> findCountryById(Long countryId);

    List<Country> findAllCountries();

    List<Country> findCountryByOrderByIdDesc();

    void deleteCountry(Long countryId);


}
