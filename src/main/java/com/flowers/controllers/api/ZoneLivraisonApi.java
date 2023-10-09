package com.flowers.controllers.api;

import com.flowers.dtos.CategoryDto;
import com.flowers.dtos.ZoneLivraisonDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

@RequestMapping(value = APP_ROOT + "/zonelivraison")
public interface ZoneLivraisonApi {

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une Zone de ivraison",
            notes = "Cette méthode permet d'ajouter une Category", response = ZoneLivraisonDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Zone de livraison a été crée"),
            @ApiResponse(code = 400, message = "Aucune Zone livraison  crée / modifié")
    })
    ResponseEntity<ZoneLivraisonDto> createZoneLivraison(@RequestBody ZoneLivraisonDto zoneLivraisonDto);

    @PutMapping(value = "/update/{zoneId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Zone de livraison par son ID",
            notes = "Cette méthode permet de modifier une Category par son ID", response = ZoneLivraisonDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Zone de livraison a été modifiée"),
            @ApiResponse(code = 400, message = "La Zone de livraison a n'est pas modifiée")
    })
    ResponseEntity<ZoneLivraisonDto> updateZoneLivraison(@PathVariable(value = "zoneId") Long zoneId, @RequestBody ZoneLivraisonDto zoneLivraisonDto);

    @GetMapping(value = "/findById/{zoneId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une ZoneLivraison par ID",
            notes = "Cette méthode permet de chercher une ZoneLivraison par son ID", response = ZoneLivraisonDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La ZoneLivraison a été trouver"),
            @ApiResponse(code = 404, message = "Aucun ZoneLivraison n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<ZoneLivraisonDto> getZoneLivraisonById(@PathVariable(value = "zoneId") Long zoneId);

    @GetMapping(value = "/search-all-active-zone-livraisons", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des ZoneLivraison actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des ZoneLivraison actives",
            responseContainer = "List<ZoneLivraisonDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des categories par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<ZoneLivraisonDto>> getAllActiveZoneLivraisons();

    @DeleteMapping(value = "/delete-zone-livraison/{zoneId}")
    @ApiOperation(value = "Supprimer une ZoneLivraison par son ID",
            notes = "Cette méthode permet de supprimer une ZoneLivraisonDto  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La ZoneLivraisonDto a été supprimé")
    })
    void deleteZoneLivraison(@PathVariable("zoneId") Long zoneId);
}
