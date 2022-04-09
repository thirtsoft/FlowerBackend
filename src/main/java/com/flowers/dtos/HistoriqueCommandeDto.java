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

    public static HistoriqueCommandeDto fromEntityToDto(HistoriqueCommande historiqueCommande) {
        if (historiqueCommande == null) {
            return null;
        }
        return HistoriqueCommandeDto.builder()
                .id(historiqueCommande.getId())
                .action(historiqueCommande.getAction())
                .createdDate(historiqueCommande.getCreatedDate())
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
        historiqueCommande.setCommande(CommandeDto.fromDtoToEntity(historiqueCommandeDto.getCommandeDto()));

        return historiqueCommande;
    }
}
