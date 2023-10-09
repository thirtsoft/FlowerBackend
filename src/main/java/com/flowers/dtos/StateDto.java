package com.flowers.dtos;

import com.flowers.models.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StateDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private CountryDto countryDto;

    private ZoneLivraisonDto zoneLivraisonDto;

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

    public static StateDto fromEntityToDto(State state) {
        if (state == null) {
            return null;
        }

        return StateDto.builder()
                .id(state.getId())
                .name(state.getName())
                .actif(state.getActif())
                .countryDto(CountryDto.fromEntityToDto(state.getCountry()))
                .zoneLivraisonDto(ZoneLivraisonDto.fromEntityToDto(state.getZoneLivraison()))
                .build();
    }

    public static State fromDtoToEntity(StateDto stateDto) {
        if (stateDto == null) {
            return null;
        }

        State state = new State();
        state.setId(stateDto.getId());
        state.setName(stateDto.getName());
        state.setActif(stateDto.isActif());
        state.setCountry(CountryDto.fromDtoToEntity(stateDto.getCountryDto()));
        state.setZoneLivraison(ZoneLivraisonDto.fromDtoToEntity(stateDto.getZoneLivraisonDto()));
        return state;
    }
}
