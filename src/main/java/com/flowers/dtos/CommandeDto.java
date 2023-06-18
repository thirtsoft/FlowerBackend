package com.flowers.dtos;

import com.flowers.models.Commande;
import com.flowers.models.LigneCommande;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDto {

    private Long id;

    @NotNull
    private Long numeroCommande;

    @NotNull
    private double totalCommande;

    private int totalQuantity;

    private String orderTrackingNumber;

    private String status;

    private String sessionId;

    private Date dateCommande;

    private ClientDto clientDto;

    private UtilisateurDto utilisateurDto;

    private AddressDto billingAddressDto;

    private List<LigneCommande> lcomms = new ArrayList<>();

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

    public static CommandeDto fromEntityToDto(Commande commande) {
        if (commande == null) {
            return null;
        }

        return CommandeDto.builder()
                .id(commande.getId())
                .numeroCommande(commande.getNumeroCommande())
                .totalCommande(commande.getTotalCommande())
                .totalQuantity(commande.getTotalQuantity())
                .dateCommande(commande.getDateCommande())
                .status(commande.getStatus())
                .actif(commande.getActif())
                .orderTrackingNumber(commande.getOrderTrackingNumber())
                .clientDto(ClientDto.fromEntityToDto(commande.getClient()))
                .utilisateurDto(UtilisateurDto.fromEntityToDto(commande.getUtilisateur()))
                .billingAddressDto(AddressDto.fromEntityToDto(commande.getBillingAddress()))
                .lcomms(commande.getLcomms())
                .build();

    }

    public static Commande fromDtoToEntity(CommandeDto commandeDto) {
        if (commandeDto == null) {
            return null;
        }

        Commande commande = new Commande();
        commande.setId(commandeDto.getId());
        commande.setNumeroCommande(commandeDto.getNumeroCommande());
        commande.setDateCommande(commandeDto.getDateCommande());
        commande.setOrderTrackingNumber(commandeDto.getOrderTrackingNumber());
        commande.setTotalCommande(commandeDto.getTotalCommande());
        commande.setTotalQuantity(commandeDto.getTotalQuantity());
        commande.setStatus(commandeDto.getStatus());
        commande.setActif(commandeDto.isActif());
        commande.setDateCommande(commandeDto.getDateCommande());
        commande.setClient(ClientDto.fromDtoToEntity(commandeDto.getClientDto()));
        commande.setUtilisateur(UtilisateurDto.fromDtoToEntity(commandeDto.getUtilisateurDto()));
        commande.setBillingAddress(AddressDto.fromDtoToEntity(commandeDto.getBillingAddressDto()));
        commande.setLcomms(commandeDto.getLcomms());
        return commande;
    }
}
