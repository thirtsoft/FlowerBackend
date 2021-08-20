package com.flowers.services.Impl;

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
        return null;
    }

    @Override
    public State updateState(Long stateId, State state) {
        return null;
    }

    @Override
    public Optional<State> findStateById(Long stateId) {
        return Optional.empty();
    }

    @Override
    public State findByCode(String code) {
        return null;
    }

    @Override
    public State findByDesignation(String designation) {
        return null;
    }

    @Override
    public List<State> findAllStates() {
        return null;
    }

    @Override
    public void deleteState(Long stateId) {

    }

    @Override
    public List<State> ListStateByCode(String designation) {
        return null;
    }

    @Override
    public List<State> ListStateByDesignation(String designation) {
        return null;
    }
}
