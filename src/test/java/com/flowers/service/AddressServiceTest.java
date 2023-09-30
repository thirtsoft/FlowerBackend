package com.flowers.service;


import com.flowers.dtos.AddressDto;
import com.flowers.models.Address;
import com.flowers.models.State;
import com.flowers.reposiory.AddressRepository;
import com.flowers.reposiory.StateRepository;
import com.flowers.services.Impl.AddressServiceImpl;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AddressServiceTest {

    @InjectMocks
    private AddressServiceImpl addressService;

    @Mock
    private AddressRepository addressRepository;

    @Mock private StateRepository stateRepository;

    @Test
    public void should_find_and_return_one_address() {
        Address address = new Address();
        address.setRue("Rue 140 SN");
        address.setCity("Dakar");

        when(addressRepository.findById(anyLong())).thenReturn(Optional.of(address));

        AddressDto addressDtoResult =  addressService.findAddressById(anyLong());

        Address addressResult = AddressDto.fromDtoToEntity(addressDtoResult);

        assertThat(addressResult).usingRecursiveComparison().isEqualTo(address);
        verify(addressRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(addressRepository);
    }

    @Test
    public void should_find_and_return_all_address() {
        Address address = new Address();
        address.setRue("Rue 140 SN");
        address.setCity("Dakar");

        when(addressRepository.findAll()).thenReturn(singletonList(address));

        List<AddressDto> addressList = addressService.findAllActiveAddress();

        assertThat(addressList).isNotNull();
        assertThat(addressList).hasSize(1);
        verify(addressRepository, times(1)).findAll();
        verifyNoMoreInteractions(addressRepository);
    }

    @Test
    public void should_find_and_return_all_address_by_IdDesc() {
        Address address = new Address();
        address.setRue("Rue 140 SN");
        address.setCity("Dakar");

        when(addressRepository.findAll()).thenReturn(singletonList(address));

        List<AddressDto> addressList = addressService.findAllActiveAddress();

        assertThat(addressList).hasSize(1);
        verify(addressRepository, times(1)).findAll();
        verifyNoMoreInteractions(addressRepository);
    }

    @Test
    public void should_delete_one_address() {
        doNothing().when(addressRepository).deleteById(anyLong());

        addressService.deleteAddress(anyLong());
        verify(addressRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(addressRepository);
    }


}
