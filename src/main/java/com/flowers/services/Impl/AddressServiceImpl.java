package com.flowers.services.Impl;

import com.flowers.models.Address;
import com.flowers.models.Category;
import com.flowers.reposiory.AddressRepository;
import com.flowers.reposiory.CategoryRepository;
import com.flowers.services.AddressService;
import com.flowers.services.CategoryService;
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
    public Address saveAddress(Address Address) {
        return null;
    }

    @Override
    public Address updateAddress(Long catId, Address Address) {
        return null;
    }

    @Override
    public Optional<Address> findAddressById(Long catId) {
        return Optional.empty();
    }

    @Override
    public Address findByCode(String code) {
        return null;
    }

    @Override
    public Address findByDesignation(String designation) {
        return null;
    }

    @Override
    public List<Address> findAllAddresses() {
        return null;
    }

    @Override
    public void deleteAddress(Long catId) {

    }

    @Override
    public List<Address> ListAddressByCode(String designation) {
        return null;
    }

    @Override
    public List<Address> ListAddressByDesignation(String designation) {
        return null;
    }
}
