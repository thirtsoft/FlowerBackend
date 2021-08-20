package com.flowers.controllers;

import com.flowers.controllers.api.AddressApi;
import com.flowers.models.Address;
import com.flowers.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AddressController implements AddressApi {

    private final AddressService addressService;

    @Override
    public ResponseEntity<Address> saveAddress(Address address) {
        return null;
    }

    @Override
    public ResponseEntity<Address> updateAddress(Long catId, Address address) {
        return null;
    }

    @Override
    public ResponseEntity<Address> findAddressById(Long catId) {
        return null;
    }

    @Override
    public ResponseEntity<Address> findByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<Address> findByDesignation(String designation) {
        return null;
    }

    @Override
    public ResponseEntity<List<Address>> getAlladdresses() {
        return null;
    }

    @Override
    public ResponseEntity<List<Address>> getListaddressesByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<List<Address>> getListaddressesByDesignation(String designation) {
        return null;
    }

    @Override
    public void deleteAddress(Long catId) {

    }
}
