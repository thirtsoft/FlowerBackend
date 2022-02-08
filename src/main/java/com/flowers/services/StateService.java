package com.flowers.services;

import com.flowers.models.State;

import java.util.List;
import java.util.Optional;

public interface StateService {

    State saveState(State state);

    State updateState(Long stateId, State state);

    Optional<State> findStateById(Long stateId);

    List<State> findAllStates();

    List<State> findStateByOrderByIdDesc();

    List<State> findAllStateByCountryCode(String code);

    void deleteState(Long stateId);

}
