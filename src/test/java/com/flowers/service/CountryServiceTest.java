package com.flowers.service;


import com.flowers.dtos.CountryDto;
import com.flowers.models.Country;
import com.flowers.reposiory.CountryRepository;
import com.flowers.services.Impl.CountryServiceImpl;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CountryServiceTest {

    @InjectMocks
    private CountryServiceImpl countryService;

    @Mock
    private CountryRepository countryRepository;

    @Test
    public void should_save_one_country() {
        Country country = new Country();
        country.setId(1L);
        country.setCode("SEN");
        country.setName("SENEGAL");

        when(countryRepository.save(any(Country.class))).thenReturn(country);

        CountryDto countryDto = countryService.saveCountry(CountryDto.fromEntityToDto(new Country()));

        Country countryResult = CountryDto.fromDtoToEntity(countryDto);

        assertThat(countryResult).usingRecursiveComparison().isEqualTo(country);
        verify(countryRepository, times(1)).save(any(Country.class));
        verifyNoMoreInteractions(countryRepository);
    }

    @Test
    public void should_find_and_return_one_country() {
        Country country = new Country();
        country.setId(2L);
        country.setCode("USA");
        country.setName("ETATS-UNIS");

        when(countryRepository.findById(anyLong())).thenReturn(Optional.of(country));

        CountryDto countryDtoResult = countryService.findCountryById(anyLong());

        Country countryResult = CountryDto.fromDtoToEntity(countryDtoResult);

        assertThat(countryResult).usingRecursiveComparison().isEqualTo(country);
        verify(countryRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(countryRepository);
    }

    @Test
    public void should_update_country() {
        Country country = new Country();
        country.setId(3L);
        country.setCode("SENS");
        country.setName("SENS");

        when(countryRepository.findById(anyLong())).thenReturn(Optional.of(country));

        CountryDto countryDtoResult = countryService.findCountryById(anyLong());
        countryDtoResult.setName("Country002");
        countryService.saveCountry(countryDtoResult);

        Country countryResult = CountryDto.fromDtoToEntity(countryDtoResult);

        assertThat(countryResult).usingRecursiveComparison().isNotEqualTo(country);
        assertThat(countryResult.getName()).isEqualTo("Country002");

    }


    @Test
    public void should_find_and_return_all_countries() {
        Country country = new Country();
        country.setId(4L);
        country.setCode("GUN");
        country.setName("GUNS");

        when(countryRepository.findAll()).thenReturn(singletonList(country));

        List<CountryDto> countryList = countryService.findAllActiveCountries();

        assertThat(countryList).isNotNull();
        assertThat(countryList).hasSize(1);
        verify(countryRepository, times(1)).findAll();
        verifyNoMoreInteractions(countryRepository);
    }

    @Test
    public void should_find_and_return_all_countries_by_Id_desc() {
        Country country = new Country();
        country.setId(5L);
        country.setCode("MAL");
        country.setName("MALI");

        when(countryRepository.findAll()).thenReturn(singletonList(country));

        List<CountryDto> countryList = countryService.findAllActiveCountries();

        assertThat(countryList).hasSize(1);
        verify(countryRepository, times(1)).findAll();
        verifyNoMoreInteractions(countryRepository);
    }

    @Test
    public void should_delete_one_country() {
        doNothing().when(countryRepository).deleteById(anyLong());

        countryService.deleteCountry(anyLong());
        verify(countryRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(countryRepository);
    }


}
