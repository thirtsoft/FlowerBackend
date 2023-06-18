package com.flowers.dtos;

import com.flowers.models.HistoriqueLogin;
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
public class HistoriqueLoginDto {

    private Long id;

    @NotNull
    private String action;

    private String status;

    private Date createdDate;

    private UtilisateurDto utilisateurDto;

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

    public static HistoriqueLoginDto fromEntityToDto(HistoriqueLogin historiqueLogin) {
        if (historiqueLogin == null) {
            return null;
        }

        return HistoriqueLoginDto.builder()
                .id(historiqueLogin.getId())
                .action(historiqueLogin.getAction())
                .status(historiqueLogin.getStatus())
                .createdDate(historiqueLogin.getCreatedDate())
                .actif(historiqueLogin.getActif())
                .utilisateurDto(UtilisateurDto.fromEntityToDto(historiqueLogin.getUtilisateur()))
                .build();
    }

    public static HistoriqueLogin fromDtoToEntity(HistoriqueLoginDto historiqueLoginDto) {
        if (historiqueLoginDto == null) {
            return null;
        }

        HistoriqueLogin historiqueLogin = new HistoriqueLogin();
        historiqueLogin.setId(historiqueLoginDto.getId());
        historiqueLogin.setAction(historiqueLoginDto.getAction());
        historiqueLogin.setStatus(historiqueLoginDto.getStatus());
        historiqueLogin.setCreatedDate(historiqueLoginDto.getCreatedDate());
        historiqueLogin.setActif(historiqueLoginDto.isActif());
        historiqueLogin.setUtilisateur(UtilisateurDto.fromDtoToEntity(historiqueLoginDto.getUtilisateurDto()));
        return historiqueLogin;
    }

}
