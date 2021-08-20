package com.flowers.services;

import com.flowers.models.State;

import java.util.List;
import java.util.Optional;

public interface StateService {

    State saveState(State state);

    State updateState(Long stateId, State state);

    Optional<State> findStateById(Long stateId);

    State findByCode(String code);

    State findByDesignation(String designation);

    List<State> findAllStates();

    void deleteState(Long stateId);

    List<State> ListStateByCode(String designation);

    List<State> ListStateByDesignation(String designation);


}
