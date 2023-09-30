package com.flowers.services.Impl;

import com.flowers.dtos.CountryDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Country;
import com.flowers.reposiory.CountryRepository;
import com.flowers.services.CountryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CountryServiceImpl implements CountryService {

    @Autowired
    private final CountryRepository countryRepository;

    @Override
    public CountryDto saveCountry(CountryDto countryDto) {
        countryDto.setActif(true);
        return CountryDto.fromEntityToDto(
                countryRepository.save(
                        CountryDto.fromDtoToEntity(countryDto)
                )
        );
    }

    @Override
    public CountryDto updateCountry(Long countryId, CountryDto countryDto) {
        if (!countryRepository.existsById(countryId)) {
            throw new ResourceNotFoundException("Country not found");
        }
        Optional<Country> optionalCountry = countryRepository.findById(countryId);
        if (!optionalCountry.isPresent()) {
            throw new ResourceNotFoundException("Country not found");
        }
        CountryDto countryDtoResult = CountryDto.fromEntityToDto(optionalCountry.get());
        countryDtoResult.setCode(countryDto.getCode());
        countryDtoResult.setName(countryDto.getName());
        return CountryDto.fromEntityToDto(
                countryRepository.save(
                        CountryDto.fromDtoToEntity(countryDtoResult)
                )
        );
    }

    @Override
    public CountryDto findCountryById(Long countryId) {
        if (countryId == null) {
            log.error("Country Id is null");
            return null;
        }
        Optional<Country> optionalCountry = countryRepository.findById(countryId);
        return Optional.of(CountryDto.fromEntityToDto(optionalCountry.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun Country avec l'Id = " + countryId + "n'a été trouvé")
        );
    }

    @Override
    public List<CountryDto> findAllActiveCountries() {
        return countryRepository.findAll().stream()
                .map(CountryDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCountry(Long countryId) {
        if (countryId == null) {
            log.error("Country Id is null");
            return;
        }
        Country country = countryRepository.findById(countryId).get();
        country.setActif(false);
        countryRepository.save(country);
    }
}
