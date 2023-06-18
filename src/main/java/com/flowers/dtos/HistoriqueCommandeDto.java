package com.flowers.dtos;

import com.flowers.models.HistoriqueCommande;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoriqueCommandeDto {

    private Long id;

    @NotNull
    private String action;

    private Date createdDate;

    private CommandeDto commandeDto;

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

    public static HistoriqueCommandeDto fromEntityToDto(HistoriqueCommande historiqueCommande) {
        if (historiqueCommande == null) {
            return null;
        }
        return HistoriqueCommandeDto.builder()
                .id(historiqueCommande.getId())
                .action(historiqueCommande.getAction())
                .createdDate(historiqueCommande.getCreatedDate())
                .actif(historiqueCommande.getActif())
                .commandeDto(CommandeDto.fromEntityToDto(historiqueCommande.getCommande()))
                .build();
    }

    public static HistoriqueCommande fromDtoToEntity(HistoriqueCommandeDto historiqueCommandeDto) {
        if (historiqueCommandeDto == null) {
            return null;
        }
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setId(historiqueCommandeDto.getId());
        historiqueCommande.setAction(historiqueCommandeDto.getAction());
        historiqueCommande.setCreatedDate(historiqueCommandeDto.getCreatedDate());
        historiqueCommande.setActif(historiqueCommandeDto.isActif());
        historiqueCommande.setCommande(CommandeDto.fromDtoToEntity(historiqueCommandeDto.getCommandeDto()));
        return historiqueCommande;
    }
}
