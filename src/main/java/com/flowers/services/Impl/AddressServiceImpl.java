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
        if (!addressRepository.existsById(addId)) {
            throw new ResourceNotFoundException("Address that id is " + addId + "not found");
        }

        Optional<Address> optionalAddress = addressRepository.findById(addId);

        if (!optionalAddress.isPresent()) {
            throw new ResourceNotFoundException("Address not found");
        }

        Address addressResult = optionalAddress.get();
        addressResult.setReference(address.getReference());
        addressResult.setCity(address.getCity());
        addressResult.setPhone(address.getPhone());
        addressResult.setQuartier(address.getQuartier());
        addressResult.setRue(address.getRue());
        addressResult.setState(address.getState());

        return addressRepository.save(addressResult);
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
    public List<Address> findAddressByOrderByIdDesc() {
        return addressRepository.findByOrderByIdDesc();
    }

    @Override
    public void deleteAddress(Long addId) {
        if (!addressRepository.existsById(addId)) {
            throw new ResourceNotFoundException("Address not found");
        }
        addressRepository.deleteById(addId);
    }

}
