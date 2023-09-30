package com.flowers.services;

import com.flowers.dtos.AddressDto;

import java.util.List;

public interface AddressService {

    AddressDto findAddressById(Long addId);
    
    List<AddressDto> findAllActiveAddress();

    void deleteAddress(Long addressId);


}
