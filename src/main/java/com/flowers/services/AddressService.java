package com.flowers.services;

import com.flowers.models.Address;
import com.flowers.models.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Address saveAddress(Address address);

    Address updateAddress(Long catId, Address address);

    Optional<Address> findAddressById(Long addId);

    List<Address> findAllAddresses();

    List<Address> findAddressByOrderByIdDesc();

    void deleteAddress(Long addId);


}
