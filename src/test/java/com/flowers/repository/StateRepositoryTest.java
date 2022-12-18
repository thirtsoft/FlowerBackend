package com.flowers.repository;

import com.flowers.models.Country;
import com.flowers.models.State;
import com.flowers.reposiory.CountryRepository;
import com.flowers.reposiory.StateRepository;
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
public class StateRepositoryTest {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_state_Test() {
        Country country = new Country();
        country.setCode("SN");
        country.setName("SENEGAL");
        countryRepository.save(country);
        State state = new State();
        state.setId(1L);
        state.setName("Ziguinchor");
        state.setCountry(country);
        stateRepository.save(state);

        assertThat(state.getId()).isGreaterThan(0);
        assertThat(state.getName()).isNotNull();
        assertThat(state.getCountry()).isEqualTo(country);
    }


    @Test
    @Order(2)
    public void get_and_return_on_state_by_Id_Test() {
        Country country = new Country();
        country.setCode("SN");
        country.setName("SENEGAL");
        countryRepository.save(country);
        State state = new State();
        state.setId(2L);
        state.setName("Ziguinchor");
        state.setCountry(country);
        stateRepository.save(state);

        State optionalState = stateRepository.findById(state.getId()).get();

        assertThat(optionalState.getId()).isEqualTo(state.getId());
        assertThat(optionalState.getName()).isEqualTo(state.getName());
    }


    @Test
    @Order(3)
    @Rollback(value = false)
    public void update_state_by_id_Test() {
        Optional<State> optionalState = stateRepository.findById(1L);
        if (optionalState.isPresent()) {
            State state = optionalState.get();
            state.setName("Dakar");

            State stateUpdated = stateRepository.save(state);
            assertThat(stateUpdated.getId()).isEqualTo(state.getId());
            assertThat(state.getName()).isEqualTo("Dakar");
        }
    }

    @Test
    @Order(4)
    public void should_and_return_all_states_Test() {
        Country country = new Country();
        country.setCode("SN");
        country.setName("SENEGAL");
        countryRepository.save(country);
        State state = new State();
        state.setId(3L);
        state.setName("Ziguinchor");
        state.setCountry(country);
        stateRepository.save(state);

        List<State> stateList = stateRepository.findAll();

        assertThat(stateList.size()).isNotNull();
        assertThat(stateList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(5)
    public void should_and_return_all_states_by_IdDesc_Test() {
        Country country = new Country();
        country.setCode("SN");
        country.setName("SENEGAL");
        countryRepository.save(country);
        State state = new State();
        state.setId(3L);
        state.setName("Ziguinchor");
        state.setCountry(country);
        stateRepository.save(state);

        List<State> stateList = stateRepository.findByOrderByIdDesc();

        assertThat(stateList.size()).isNotNull();
        assertThat(stateList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(6)
    public void should_and_return_states_by_country_code_Test() {
        String code = "SEN";
        List<State> stateList = stateRepository.findAllStateByCountryCode(code);

        assertThat(stateList.size()).isNotNull();
        assertThat(stateList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(7)
    @Rollback(value = false)
    public void delete_state_by_id_Test() {
        Optional<State> optionalState = stateRepository.findById(1L);
        if (optionalState.isPresent()) {
            stateRepository.delete(optionalState.get());
        }
        State state = null;
        Optional<State> optionalState01 = stateRepository.findById(1L);
        if (optionalState01.isPresent()) {
            state = optionalState01.get();
        }
        assertThat(state).isNull();
    }

}
