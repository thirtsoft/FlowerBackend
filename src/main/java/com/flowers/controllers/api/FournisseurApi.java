package com.flowers.controllers.api;

import com.flowers.dtos.EmailDto;
import com.flowers.dtos.FournisseurDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Fournisseur;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

@RequestMapping(value = APP_ROOT + "/fournisseurs")
public interface FournisseurApi {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une Fournisseur",
            notes = "Cette méthode permet d'ajouter un Fournisseur", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Le Fournisseur a été crée"),
            @ApiResponse(code = 400, message = "Aucun Fournisseur  crée / modifié")

    })
    ResponseEntity<FournisseurDto> saveFournisseur(@RequestBody FournisseurDto fournisseurDto);

    @PutMapping(value = "/update/{idFournisseur}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier un Fournisseur",
            notes = "Cette méthode permet de modifier un Fournisseur", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Fournisseur a été crée"),
            @ApiResponse(code = 400, message = "Aucun Fournisseur  crée / modifié")

    })
    ResponseEntity<FournisseurDto> updateFournisseur(@PathVariable("idFournisseur") Long id, @RequestBody FournisseurDto fournisseurDto);

    @GetMapping(value = "/findById/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Chercher un Fournisseur",
            notes = "Cette méthode permet de chercher et de renvoyer un Fournisseur", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address a été trouvé")

    })
    ResponseEntity<FournisseurDto> getFournisseurById(@PathVariable("idFournisseur") Long id);

    @GetMapping(value = "/count-number-of-fournisseur", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Fournisseur",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Fournisseur")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Fournisseur / le nombre est nulle")
    })
    BigDecimal countNumberOfFournisseur();

    @GetMapping(value = "/search-all-active-fournisseurs", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des fournisseurs actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des fournisseurs actives",
            responseContainer = "List<FournisseurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des fournisseurs par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<FournisseurDto>> getAllActiveFournisseurs();

    @DeleteMapping(value = "/delete-fournisseur/{idFournisseur}")
    @ApiOperation(value = "Supprimer un fournisseur par son ID",
            notes = "Cette méthode permet de supprimer un fournisseur  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le fournisseur a été supprimé")
    })
    void deleteFournisseur(@PathVariable("idFournisseur") Long idFournisseur);
}
