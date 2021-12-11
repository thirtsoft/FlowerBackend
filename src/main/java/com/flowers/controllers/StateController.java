package com.flowers.controllers;

import com.flowers.controllers.api.StateApi;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Fournisseur;
import com.flowers.models.State;
import com.flowers.services.StateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StateController implements StateApi {

    private final StateService stateService;


    @Override
    public ResponseEntity<State> saveState(State state) {
        return ResponseEntity.ok(stateService.saveState(state));
    }

    @Override
    public ResponseEntity<State> updateState(Long stateId, State state) {
        state.setIdState(stateId);
        return ResponseEntity.ok(stateService.saveState(state));
    }

    @Override
    public ResponseEntity<State> getStateById(Long stateId) throws ResourceNotFoundException {
        State state = stateService.findStateById(stateId)
                .orElseThrow(() -> new ResourceNotFoundException("State not found"));
        return ResponseEntity.ok().body(state);
    }

    @Override
    public ResponseEntity<List<State>> getAllStates() {
        return ResponseEntity.ok(stateService.findAllStates());
    }

    @Override
    public ResponseEntity<List<State>> getAllStatesOrderByIdDesc() {
        List<State> stateList = stateService.findStateByOrderByIdDesc();
        return new ResponseEntity<>(stateList, HttpStatus.OK);
    }

    @Override
    public void deleteState(Long stateId) {
        stateService.deleteState(stateId);
    }
}
