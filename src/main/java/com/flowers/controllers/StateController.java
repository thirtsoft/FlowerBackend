package com.flowers.controllers;

import com.flowers.controllers.api.StateApi;
import com.flowers.models.State;
import com.flowers.services.StateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StateController implements StateApi {

    private final StateService stateService;

    @Override
    public ResponseEntity<State> saveState(State State) {
        return null;
    }

    @Override
    public ResponseEntity<State> updateState(Long catId, State State) {
        return null;
    }

    @Override
    public ResponseEntity<State> findStateById(Long catId) {
        return null;
    }

    @Override
    public ResponseEntity<State> findByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<State> findByDesignation(String designation) {
        return null;
    }

    @Override
    public ResponseEntity<List<State>> getAllStates() {
        return null;
    }

    @Override
    public ResponseEntity<List<State>> getListStatesByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<List<State>> getListstatesByDesignation(String designation) {
        return null;
    }

    @Override
    public void deleteState(Long catId) {

    }
}
