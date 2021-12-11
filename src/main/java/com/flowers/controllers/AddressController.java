package com.flowers.controllers;

import com.flowers.controllers.api.AddressApi;
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
    public ResponseEntity<Address> saveAddress(Address address) {
        return ResponseEntity.ok(addressService.saveAddress(address));
    }

    @Override
    public ResponseEntity<Address> updateAddress(Long addId, Address address) {
        address.setId(addId);
        return ResponseEntity.ok(addressService.saveAddress(address));
    }

    @Override
    public ResponseEntity<Address> getAddressById(Long addId) throws ResourceNotFoundException {
        Address address = addressService.findAddressById(addId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));
        return ResponseEntity.ok().body(address);
    }

    @Override
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok(addressService.findAllAddresses());
    }

    @Override
    public ResponseEntity<List<Address>> getAllAddressesOrderByIdDesc() {
        return ResponseEntity.ok(addressService.findAddressByOrderByIdDesc());
    }

    @Override
    public ResponseEntity<?> deleteAddress(Long addId) {
        addressService.deleteAddress(addId);
        return ResponseEntity.ok().build();
    }
}
