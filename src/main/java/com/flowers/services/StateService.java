package com.flowers.services;

import com.flowers.dtos.RatingDto;
import com.flowers.dtos.StateDto;
import com.flowers.models.State;

import java.util.List;
import java.util.Optional;

public interface StateService {

    StateDto saveState(StateDto stateDto);

    StateDto updateState(Long stateId, StateDto stateDto);

    StateDto findStateById(Long stateId);

    List<StateDto> findAllStates();

    List<StateDto> findStateByOrderByIdDesc();

    List<StateDto> findAllStateByCountryCode(String code);

    void delete(Long stateId);

    List<StateDto> findAllActiveStates();

    void deleteState(Long stateId);

}
