package com.flowers.controllers;

import com.flowers.controllers.api.StateApi;
import com.flowers.dtos.StateDto;
import com.flowers.exceptions.ResourceNotFoundException;
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
    public ResponseEntity<StateDto> saveState(StateDto stateDto) {
        StateDto stateDtoResult = stateService.saveState(stateDto);
        return new ResponseEntity<>(stateDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<StateDto> updateState(Long stateId, StateDto stateDto) {
        stateDto.setId(stateId);
        StateDto stateDtoResult = stateService.saveState(stateDto);
        return new ResponseEntity<>(stateDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StateDto> getStateById(Long stateId) {
        StateDto stateDtoResult = stateService.findStateById(stateId);
        return new ResponseEntity<>(stateDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<StateDto>> getAllStates() {
        List<StateDto> stateDtoList = stateService.findAllStates();
        return new ResponseEntity<>(stateDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<StateDto>> getAllStatesOrderByIdDesc() {
        List<StateDto> stateDtoList = stateService.findStateByOrderByIdDesc();
        return new ResponseEntity<>(stateDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<StateDto>> getAllStateByCountryCode(String code) {
        List<StateDto> stateDtoList = stateService.findAllStateByCountryCode("%" + code + "%");
        return new ResponseEntity<>(stateDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteState(Long stateId) {
        stateService.deleteState(stateId);
    }
}
