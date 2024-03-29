package com.flowers.dtos;

import com.flowers.models.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;

    private String zipcode;

    private String city;

    private String rue;

    private StateDto stateDto;

    private int actif;

    public void setActif(boolean actif) {
        if (actif == true)
            this.actif = 1;
        else
            this.actif = 0;
    }

    public boolean isActif() {
        if (actif == 1)
            return true;
        else
            return false;
    }

    public static AddressDto fromEntityToDto(Address address) {
        if (address == null) {
            return null;
        }
        return AddressDto.builder()
                .id(address.getId())
                .zipcode(address.getZipcode())
                .city(address.getCity())
                .rue(address.getRue())
                .actif(address.getActif())
                .stateDto(StateDto.fromEntityToDto(address.getState()))
                .build();
    }

    public static Address fromDtoToEntity(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setCity(addressDto.getCity());
        address.setRue(addressDto.getRue());
        address.setZipcode(addressDto.getZipcode());
        address.setActif(addressDto.isActif());
        address.setState(StateDto.fromDtoToEntity(addressDto.getStateDto()));
        return address;
    }
}
