package com.flowers.services;

import com.flowers.dtos.AddressDto;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    AddressDto saveAddress(AddressDto addressDto);

    AddressDto updateAddress(Long catId, AddressDto addressDto);

    AddressDto findAddressById(Long addId);

    List<AddressDto> findAllAddresses();

    List<AddressDto> findAddressesByOrderByIdDesc();

    void deleteAddress(Long addId);


}
