package com.flowers.controllers.api;

import com.flowers.dtos.UtilisateurDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Utilisateur;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT + "/utilisateurs/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une Utilisateur",
            notes = "Cette méthode permet d'ajouter un Utilisateur", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Le Utilisateur a été crée"),
            @ApiResponse(code = 400, message = "Aucun Utilisateur  crée / modifié")

    })
    ResponseEntity<UtilisateurDto> saveUtilisateur(@RequestBody UtilisateurDto utilisateurDto);

    @PutMapping(value = APP_ROOT + "/utilisateurs/update/{userId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Utilisateur",
            notes = "Cette méthode permet de modifier une Utilisateur", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Utilisateur a été crée"),
            @ApiResponse(code = 400, message = "Aucun Utilisateur  crée / modifié")

    })
    ResponseEntity<UtilisateurDto> updateUtilisateur(@PathVariable(value = "userId") Long userId, @RequestBody UtilisateurDto utilisateurDto);

    @GetMapping(value = APP_ROOT + "/utilisateurs/findById/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Chercher une Utilisateur",
            notes = "Cette méthode permet de chercher et de renvoyer une Utilisateur", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Utilisateur a été trouvé")

    })
    ResponseEntity<UtilisateurDto> getUtilisateurById(@PathVariable(value = "userId") Long userId);

    @GetMapping(value = APP_ROOT + "/utilisateurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Utilisateur",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Utilisateur", responseContainer = "List<UtilisateurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Utilisateur / une liste vide")
    })
    ResponseEntity<List<UtilisateurDto>> getAllUtilisateurs();

    @GetMapping(value = APP_ROOT + "/utilisateurs/searchAllUtilisateursOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Utilisateur par ordre decroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Utilisateur par ordre decroissante", responseContainer = "List<UtilisateurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Utilisateur / une liste vide")
    })
    ResponseEntity<List<UtilisateurDto>> getAllUtilisateursOrderByIdDesc();

    @DeleteMapping(value = APP_ROOT + "/utilisateurs/delete/{userId}")
    @ApiOperation(value = "Supprimer un Utilisateur par son ID",
            notes = "Cette méthode permet de supprimer une Country par son ID", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Utilisateur a été supprimé")
    })
    void deleteUtilisateur(@PathVariable(name = "userId") Long userId);

}
