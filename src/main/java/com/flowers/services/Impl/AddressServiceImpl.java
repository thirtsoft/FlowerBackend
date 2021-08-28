package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Address;
import com.flowers.reposiory.AddressRepository;
import com.flowers.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;


    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long addId, Address address) {
        address.setId(addId);
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> findAddressById(Long addId) {
        if (!addressRepository.existsById(addId)) {
            throw new ResourceNotFoundException("Address that id is " + addId + "not found");
        }
        return addressRepository.findById(addId);
    }


    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteAddress(Long addId) {
        if (!addressRepository.existsById(addId)) {
            throw new ResourceNotFoundException("Address not found");
        }
        addressRepository.deleteById(addId);
    }

}
