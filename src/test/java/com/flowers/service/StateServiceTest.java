package com.flowers.service;


import com.flowers.dtos.StateDto;
import com.flowers.models.Country;
import com.flowers.models.State;
import com.flowers.reposiory.CountryRepository;
import com.flowers.reposiory.StateRepository;
import com.flowers.services.Impl.StateServiceImpl;
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
public class StateServiceTest {

    @InjectMocks
    private StateServiceImpl stateService;

    @Mock
    private StateRepository stateRepository;

    @Mock
    private CountryRepository countryRepository;

    @Test
    public void should_save_one_state() {
        Country country = new Country();
        country.setCode("SN");
        country.setName("Senegal");
        countryRepository.save(country);
        State state = new State();
        state.setId(1L);
        state.setName("Dakar");
        state.setCountry(country);

        when(stateRepository.save(any(State.class))).thenReturn(state);

        StateDto stateDto = stateService.saveState(StateDto.fromEntityToDto(new State()));

        State stateResult = StateDto.fromDtoToEntity(stateDto);

        assertThat(stateResult).usingRecursiveComparison().isEqualTo(state);
        verify(stateRepository, times(1)).save(any(State.class));
        verifyNoMoreInteractions(stateRepository);
    }

    @Test
    public void should_find_and_return_one_state() {
        Country country = new Country();
        country.setCode("SN");
        country.setName("Senegal");
        countryRepository.save(country);
        State state = new State();
        state.setId(2L);
        state.setName("Ziguinchor");
        state.setCountry(country);

        when(stateRepository.findById(anyLong())).thenReturn(Optional.of(state));

        StateDto stateDtoResult = stateService.findStateById(anyLong());

        State stateResult = StateDto.fromDtoToEntity(stateDtoResult);

        assertThat(stateResult).usingRecursiveComparison().isEqualTo(state);
        verify(stateRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(stateRepository);
    }

    @Test
    public void should_update_state() {
        Country country = new Country();
        country.setCode("SN");
        country.setName("Senegal");
        countryRepository.save(country);
        State state = new State();
        state.setId(3L);
        state.setName("Ziguinchor");
        state.setCountry(country);

        when(stateRepository.findById(anyLong())).thenReturn(Optional.of(state));

        StateDto stateDtoResult = stateService.findStateById(anyLong());
        stateDtoResult.setName("Bignona");
        stateService.saveState(stateDtoResult);

        State stateResult = StateDto.fromDtoToEntity(stateDtoResult);

        assertThat(stateResult).usingRecursiveComparison().isNotEqualTo(state);
        assertThat(stateResult.getName()).isEqualTo("Bignona");

    }


    @Test
    public void should_find_and_return_all_states() {
        State state = new State();
        state.setId(4L);
        state.setName("Ziguinchor");

        when(stateRepository.findAll()).thenReturn(singletonList(state));

        List<StateDto> stateList = stateService.findAllStates();

        assertThat(stateList).isNotNull();
        assertThat(stateList).hasSize(1);
        verify(stateRepository, times(1)).findAll();
        verifyNoMoreInteractions(stateRepository);
    }

    @Test
    public void should_find_and_return_all_states_by_Id_desc() {
        State state = new State();
        state.setId(5L);
        state.setName("Ziguinchor");

        when(stateRepository.findByOrderByIdDesc()).thenReturn(singletonList(state));

        List<StateDto> stateList = stateService.findStateByOrderByIdDesc();

        assertThat(stateList).isNotNull();
        assertThat(stateList).hasSize(1);
        verify(stateRepository, times(1)).findByOrderByIdDesc();
        verifyNoMoreInteractions(stateRepository);
    }

    @Test
    public void should_find_and_return_all_states_by_country_code() {
        String code = "SEN";

        when(stateRepository.findAllStateByCountryCode(code)).thenReturn(singletonList(any()));

        List<StateDto> stateList = stateService.findAllStateByCountryCode(code);

        assertThat(stateList).isNotNull();
        assertThat(stateList).hasSize(1);
        verify(stateRepository, times(1)).findAllStateByCountryCode(code);
        verifyNoMoreInteractions(stateRepository);
    }


    @Test
    public void should_delete_one_state() {
        doNothing().when(stateRepository).deleteById(anyLong());

        stateService.deleteState(anyLong());
        verify(stateRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(stateRepository);
    }


}
