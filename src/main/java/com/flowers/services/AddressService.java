package com.flowers.services;

import com.flowers.dtos.AddressDto;

import java.util.List;

public interface AddressService {

    AddressDto saveAddress(AddressDto addressDto);

    AddressDto updateAddress(Long catId, AddressDto addressDto);

    AddressDto findAddressById(Long addId);

    List<AddressDto> findAllAddresses();

    List<AddressDto> findAddressesByOrderByIdDesc();

    void delete(Long addId);

    List<AddressDto> findAllActiveAddress();

    void deleteAddress(Long addressId);


}
