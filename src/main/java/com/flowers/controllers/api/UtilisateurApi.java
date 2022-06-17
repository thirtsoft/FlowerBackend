package com.flowers.controllers.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.flowers.dtos.UtilisateurDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Utilisateur;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping(value = APP_ROOT + "/utilisateurs/searchUtilisateurByUsername", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une utilisateur par son username",
            notes = "Cette méthode permet de chercher un utilisateur par son nom d'utilisateur", response = UtilisateurDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'utilisateur a été trouver avec cet identifiant fourni"),
            @ApiResponse(code = 404, message = "Aucun Utilisateur n'existe avec ce username pas dans la BD")

    })
    ResponseEntity<UtilisateurDto> getUtilisateurByUsername(@RequestParam(value = "username") String username);

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

    @PatchMapping(value = APP_ROOT + "/utilisateurs/updateUsernameOfUserByUsername")
    @ApiOperation(value = "Modifier le username par son username",
            notes = "Cette méthode permet de modifier le nom d'utilisateur d'un utilisateur par son username", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nom d'utlisateur a été été modifié"),
            @ApiResponse(code = 400, message = "Aucun username n'a été modifié")
    })
    ResponseEntity<Boolean> updateUsername(@RequestBody ObjectNode json);

    @PatchMapping(value = APP_ROOT + "/utilisateurs/updateUsernameOfUserById")
    @ApiOperation(value = "Modifier le username par son ID",
            notes = "Cette méthode permet de modifier le nom d'utilisateur d'un utilisateur par son ID", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nom d'utlisateur a été été modifié"),
            @ApiResponse(code = 400, message = "Aucun username n'a été modifié")
    })
    ResponseEntity<Boolean> updateUsernameByUserId(@RequestBody ObjectNode json);

    @PatchMapping(value = APP_ROOT + "/utilisateurs/updatePasswordByUsername")
    @ApiOperation(value = "Modifier le mot de passe par son Username ",
            notes = "Cette méthode permet de modifier le mot de passe d'un utilisateur par son Username", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le mot de passe a été été modifié"),
            @ApiResponse(code = 400, message = "Aucun mot de passe n'a été modifié avec ce username")
    })
    ResponseEntity<Boolean> updatePasswordByUsername(@RequestBody ObjectNode json);

    @PatchMapping(value = APP_ROOT + "/utilisateurs/updatePasswordByUserId")
    @ApiOperation(value = "Modifier le mot de passe par son ID ",
            notes = "Cette méthode permet de modifier le mot de passe d'un utilisateur par son ID", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le mot de passe a été été modifié"),
            @ApiResponse(code = 400, message = "Aucun mot de passe n'a été modifié avec ce username")
    })
    ResponseEntity<Boolean> updatePasswordByUserId(@RequestBody ObjectNode json);

    @PatchMapping(value = APP_ROOT + "/utilisateurs/updateCustomerProfileByUsername")
    @ApiOperation(value = "Modifier le mot de passe par son username ",
            notes = "Cette méthode permet de modifier le mot de passe d'un utilisateur par son username", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le mot de passe a été été modifié"),
            @ApiResponse(code = 400, message = "Aucun mot de passe n'a été modifié avec ce username")
    })
    ResponseEntity<Boolean> updateCustomerProfileByUsername(@RequestBody ObjectNode json);

    @PatchMapping(value = APP_ROOT + "/utilisateurs/activatedUser/{id}")
    @ApiOperation(value = "Activer un utilisateur",
            notes = "Cette méthode permet d'activer le compter d'un utilisateur pour se connecter")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le compte utlisateur a été été activer"),
            @ApiResponse(code = 400, message = "Aucun compte utilisateur activer")
    })
    ResponseEntity<?> activatedUser(@RequestParam("isActive") String isActive, @PathVariable("id") String id);

    @GetMapping(value = APP_ROOT + "/utilisateurs/avatar/{id}")
    @ApiOperation(value = "Recupérer une photo par ID",
            notes = "Cette méthode permet de chercher et d'afficher la photo d'un Utilisateur par son ID"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La photo de l'utilisateur a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Photo n'existe avec cette ID pas dans la BD")

    })
    byte[] getPhoto(@PathVariable("id") Long id) throws Exception;

    @PostMapping(value = APP_ROOT + "/utilisateurs/uploadUserPhoto/{id}")
    @ApiOperation(value = "Enregistrer une photo dans un dossier",
            notes = "Cette méthode permet d'enregistrer la photo d'un utilisateur dans un dossier externe utilisateur")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La photo a été enregistré dans le dossier utilisateur")
    })
    void uploadUserPhoto(MultipartFile file, @PathVariable("id") Long id) throws IOException;

    @DeleteMapping(value = APP_ROOT + "/utilisateurs/delete/{userId}")
    @ApiOperation(value = "Supprimer un Utilisateur par son ID",
            notes = "Cette méthode permet de supprimer une Country par son ID", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Utilisateur a été supprimé")
    })
    void deleteUtilisateur(@PathVariable(name = "userId") Long userId);

}
