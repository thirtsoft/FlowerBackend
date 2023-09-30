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
    public ResponseEntity<AddressDto> getAddressById(Long addId) {
        AddressDto addressDtoResult = addressService.findAddressById(addId);
        return new ResponseEntity<>(addressDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AddressDto>> getAllActiveAddresses() {
        List<AddressDto> addressDtoList = addressService.findAllActiveAddress();
        return new ResponseEntity<>(addressDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteAddress(Long addId) {
        addressService.deleteAddress(addId);
    }
}
