package com.flowers.repository;

import com.flowers.models.Country;
import com.flowers.reposiory.CountryRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_country_Test() {
        Country country = new Country();
        country.setCode("COUNT01");
        country.setName("SENEGAL");
        countryRepository.save(country);

        assertThat(country.getId()).isGreaterThan(0);
        assertThat(country.getCode()).isNotNull();
        assertThat(country.getName()).isEqualTo("SENEGAL");
    }


    @Test
    @Order(2)
    public void get_and_return_on_country_by_Id_Test() {
        Country country = new Country();
        country.setCode("COUNT01");
        country.setName("SENEGAL");
        countryRepository.save(country);

        Country optionalCountry = countryRepository.findById(2L).get();

        assertThat(optionalCountry.getId()).isEqualTo(country.getId());
        assertThat(optionalCountry.getCode()).isEqualTo(country.getCode());
        assertThat(optionalCountry.getName()).isEqualTo("SENEGAL");
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void update_country_by_id_Test() {
        Optional<Country> optionalCountry = countryRepository.findById(1L);
        if (optionalCountry.isPresent()) {
            Country country = optionalCountry.get();
            country.setName("Ziguinchor");

            Country countryUpdated = countryRepository.save(country);
            assertThat(countryUpdated.getId()).isEqualTo(country.getId());
            assertThat(countryUpdated.getName()).isEqualTo("Ziguinchor");
        }
    }

    @Test
    @Order(4)
    public void should_and_return_all_countries_Test() {
        Country country = new Country();
        country.setCode("COUNT01");
        country.setName("SENEGAL");
        countryRepository.save(country);

        List<Country> countryList = countryRepository.findAll();

        assertThat(countryList.size()).isNotNull();
        assertThat(countryList.size()).isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void should_and_return_all_countries_by_IdDesc_Test() {
        Country country = new Country();
        country.setCode("COUNT01");
        country.setName("SENEGAL");
        countryRepository.save(country);

        List<Country> countryList = countryRepository.findAll();

        assertThat(countryList.size()).isNotNull();
        assertThat(countryList.size()).isGreaterThan(0);
    }

    @Test
    @Order(6)
    @Rollback(value = false)
    public void delete_country_by_id_Test() {
        Optional<Country> optionalCountry = countryRepository.findById(1L);
        if (optionalCountry.isPresent()) {
            countryRepository.delete(optionalCountry.get());
        }
        Country country = null;
        Optional<Country> optionalCountry01 = countryRepository.findById(1L);
        if (optionalCountry01.isPresent()) {
            country = optionalCountry01.get();
        }
        assertThat(country).isNull();
    }

}
