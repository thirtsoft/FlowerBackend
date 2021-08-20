package com.flowers.services.Impl;

import com.flowers.models.Category;
import com.flowers.models.Country;
import com.flowers.reposiory.CategoryRepository;
import com.flowers.reposiory.CountryRepository;
import com.flowers.services.CategoryService;
import com.flowers.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public Country saveCountry(Country country) {
        return null;
    }

    @Override
    public Country updateCountry(Long countryId, Country country) {
        return null;
    }

    @Override
    public Optional<Country> findCountryById(Long countryId) {
        return Optional.empty();
    }

    @Override
    public Country findByCode(String code) {
        return null;
    }

    @Override
    public Country findByDesignation(String designation) {
        return null;
    }

    @Override
    public List<Country> findAllCountries() {
        return null;
    }

    @Override
    public void deleteCountry(Long countryId) {

    }

    @Override
    public List<Country> ListCountryByCode(String designation) {
        return null;
    }

    @Override
    public List<Country> ListCountryByDesignation(String designation) {
        return null;
    }
}
