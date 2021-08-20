package com.flowers.services;

import com.flowers.models.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Address saveAddress(Address Address);

    Address updateAddress(Long catId, Address Address);

    Optional<Address> findAddressById(Long catId);

    Address findByCode(String code);

    Address findByDesignation(String designation);

    List<Address> findAllAddresses();

    void deleteAddress(Long catId);

    List<Address> ListAddressByCode(String designation);

    List<Address> ListAddressByDesignation(String designation);


}
