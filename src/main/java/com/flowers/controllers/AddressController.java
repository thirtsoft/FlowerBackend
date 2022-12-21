package com.flowers.controllers;

import com.flowers.controllers.api.AddressApi;
import com.flowers.dtos.AddressDto;
import com.flowers.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"https://fleurpourtous.com", "https://portail.fleurpourtous.com"})
@RestController
@AllArgsConstructor
public class AddressController implements AddressApi {

    private final AddressService addressService;


    @Override
    public ResponseEntity<AddressDto> saveAddress(AddressDto addressDto) {
        AddressDto addressDtoResult = addressService.saveAddress(addressDto);
        return new ResponseEntity<>(addressDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AddressDto> updateAddress(Long addId, AddressDto addressDto) {
        addressDto.setId(addId);
        AddressDto addressDtoResult = addressService.saveAddress(addressDto);
        return new ResponseEntity<>(addressDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddressDto> getAddressById(Long addId) {
        AddressDto addressDtoResult = addressService.findAddressById(addId);
        return new ResponseEntity<>(addressDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        List<AddressDto> addressDtoList = addressService.findAllAddresses();
        return new ResponseEntity<>(addressDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AddressDto>> getAllAddressesOrderByIdDesc() {
        List<AddressDto> addressDtoList = addressService.findAddressesByOrderByIdDesc();
        return new ResponseEntity<>(addressDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteAddress(Long addId) {
        addressService.deleteAddress(addId);
    }
}
