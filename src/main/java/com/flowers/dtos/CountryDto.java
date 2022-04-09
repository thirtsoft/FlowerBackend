package com.flowers.dtos;

import com.flowers.models.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {

    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String name;

    public static CountryDto fromEntityToDto(Country country) {
        if (country == null) {
            return null;
        }

        return CountryDto.builder()
                .id(country.getId())
                .code(country.getCode())
                .name(country.getName())
                .build();
    }

    public static Country fromDtoToEntity(CountryDto countryDto) {
        if (countryDto == null) {
            return null;
        }

        Country country = new Country();
        country.setId(countryDto.getId());
        country.setCode(countryDto.getCode());
        country.setName(countryDto.getName());

        return country;
    }

}
