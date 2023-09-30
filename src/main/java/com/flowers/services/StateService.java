package com.flowers.services;

import com.flowers.dtos.StateDto;

import java.util.List;

public interface StateService {

    StateDto saveState(StateDto stateDto);

    StateDto updateState(Long stateId, StateDto stateDto);

    StateDto findStateById(Long stateId);

    List<StateDto> findAllStateByCountryCode(String code);

    List<StateDto> findAllActiveStates();

    void deleteState(Long stateId);

}
