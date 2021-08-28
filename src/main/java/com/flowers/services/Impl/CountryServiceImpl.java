package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Country;
import com.flowers.reposiory.CountryRepository;
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
        if (country.getName() != null) {
            throw new ResourceNotFoundException("Country already exists");
        }
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Long countryId, Country country) {
        country.setIdCountry(countryId);
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> findCountryById(Long countryId) {
        if (!countryRepository.existsById(countryId)) {
            throw new ResourceNotFoundException("Country that id is " + countryId + "not found");
        }
        return countryRepository.findById(countryId);
    }


    @Override
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void deleteCountry(Long countryId) {
        if (!countryRepository.existsById(countryId)) {
            throw new ResourceNotFoundException("Country not found");
        }
        countryRepository.deleteById(countryId);
    }

}
