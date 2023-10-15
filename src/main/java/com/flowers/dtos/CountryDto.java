package com.flowers.dtos;

import com.flowers.models.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {

    private Long id;

    @NotNull(message = "Le code de la region ne doit pas etre vide")
    @NotEmpty(message = "Le code de la region ne doit pas etre vide")
    @NotBlank(message = "Le code de la region ne doit pas etre vide")
    private String code;

    @NotNull(message = "Le nom de la region ne doit pas etre vide")
    @NotEmpty(message = "Le nom de la region ne doit pas etre vide")
    @NotBlank(message = "Le nom de la region ne doit pas etre vide")
    private String name;

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

    public static CountryDto fromEntityToDto(Country country) {
        if (country == null) {
            return null;
        }

        return CountryDto.builder()
                .id(country.getId())
                .code(country.getCode())
                .name(country.getName())
                .actif(country.getActif())
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
        country.setActif(countryDto.isActif());
        return country;
    }

}
