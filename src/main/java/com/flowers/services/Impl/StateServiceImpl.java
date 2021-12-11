package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.State;
import com.flowers.reposiory.StateRepository;
import com.flowers.services.StateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    @Override
    public State saveState(State state) {
        return stateRepository.save(state);
    }

    @Override
    public State updateState(Long stateId, State state) {
        if (!stateRepository.existsById(stateId)) {
            throw new ResourceNotFoundException("State that id is" + stateId + "is not found");
        }
        Optional<State> optionalState = stateRepository.findById(stateId);

        if (!optionalState.isPresent()) {
            throw new ResourceNotFoundException("State not found");
        }

        State stateResult = optionalState.get();
        stateResult.setName(state.getName());
        stateResult.setCountry(state.getCountry());

        return stateRepository.save(stateResult);
    }

    @Override
    public Optional<State> findStateById(Long stateId) {
        if (!stateRepository.existsById(stateId)) {
            throw new ResourceNotFoundException("State that id is " + stateId + "not found");
        }
        return stateRepository.findById(stateId);
    }


    @Override
    public List<State> findAllStates() {
        return stateRepository.findAll();
    }

    @Override
    public List<State> findStateByOrderByIdDesc() {
        return stateRepository.findByOrderByIdDesc();
    }

    @Override
    public void deleteState(Long stateId) {
        if (!stateRepository.existsById(stateId)) {
            throw new ResourceNotFoundException("State not found");
        }
        stateRepository.deleteById(stateId);

    }

}
