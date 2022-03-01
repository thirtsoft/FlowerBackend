package com.flowers.services.Impl;

import com.flowers.dtos.CategoryDto;
import com.flowers.dtos.StateDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Category;
import com.flowers.models.State;
import com.flowers.reposiory.StateRepository;
import com.flowers.services.StateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    @Override
    public StateDto saveState(StateDto stateDto) {
        return StateDto.fromEntityToDto(
                stateRepository.save(
                        StateDto.fromDtoToEntity(stateDto)
                )
        );
    }

    @Override
    public StateDto updateState(Long stateId, StateDto stateDto) {
        if (!stateRepository.existsById(stateId)) {
            throw new ResourceNotFoundException("State not found");
        }

        Optional<State> optionalState = stateRepository.findById(stateId);

        if (!optionalState.isPresent()) {
            throw new ResourceNotFoundException("State not found");
        }

        StateDto stateDtoResult = StateDto.fromEntityToDto(optionalState.get());

        stateDtoResult.setName(stateDto.getName());
        stateDtoResult.setCountryDto(stateDto.getCountryDto());

        return StateDto.fromEntityToDto(
                stateRepository.save(
                        StateDto.fromDtoToEntity(stateDtoResult)
                )
        );

    }

    @Override
    public StateDto findStateById(Long stateId) {
        if (stateId == null) {
            log.error("State Id is null");
            return null;
        }

        Optional<State> optionalState = stateRepository.findById(stateId);

        return Optional.of(StateDto.fromEntityToDto(optionalState.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun State avec l'Id = " + stateId + "n'a été trouvé")
        );
    }

    @Override
    public List<StateDto> findAllStates() {
        return stateRepository.findAll().stream()
                .map(StateDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StateDto> findStateByOrderByIdDesc() {
        return stateRepository.findByOrderByIdDesc().stream()
                .map(StateDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StateDto> findAllStateByCountryCode(String code) {
        return stateRepository.findAllStateByCountryCode(code).stream()
                .map(StateDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteState(Long stateId) {
        if (stateId == null) {
            log.error("State not found");
            return;
        }
        stateRepository.deleteById(stateId);
    }
}
