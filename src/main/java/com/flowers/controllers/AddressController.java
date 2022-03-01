package com.flowers.controllers;

import com.flowers.controllers.api.AddressApi;
import com.flowers.dtos.AddressDto;
import com.flowers.exceptions.ResourceNotFoundException;
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
    public ResponseEntity<AddressDto> saveAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public ResponseEntity<AddressDto> updateAddress(Long addId, AddressDto addressDto) {
        return null;
    }

    @Override
    public ResponseEntity<AddressDto> getAddressById(Long addId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        return null;
    }

    @Override
    public ResponseEntity<List<AddressDto>> getAllAddressesOrderByIdDesc() {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteAddress(Long addId) {
        return null;
    }
}
