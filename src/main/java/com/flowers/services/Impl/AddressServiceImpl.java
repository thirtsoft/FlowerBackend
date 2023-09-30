package com.flowers.services.Impl;

import com.flowers.dtos.AddressDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Address;
import com.flowers.reposiory.AddressRepository;
import com.flowers.services.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDto findAddressById(Long addId) {
        if (addId == null) {
            log.error("Address Id is null");
            return null;
        }
        Optional<Address> address = addressRepository.findById(addId);
        return Optional.of(AddressDto.fromEntityToDto(address.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Not address with l'Id = " + addId + "n'a été found")
        );
    }

    @Override
    public List<AddressDto> findAllActiveAddress() {
        return addressRepository.findAll().stream()
                .map(AddressDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAddress(Long addId) {
        if (addId == null) {
            log.error("Address Id is null");
            return;
        }
        Address address = addressRepository.findById(addId).get();
        address.setActif(false);
        addressRepository.save(address);
    }
}
