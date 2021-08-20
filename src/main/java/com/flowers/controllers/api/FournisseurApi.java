package com.flowers.controllers.api;

import com.flowers.models.Fournisseur;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface FournisseurApi {

    @PostMapping(value = APP_ROOT + "/fournisseurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Fournisseur> save(@RequestBody Fournisseur fournisseur);

    @PutMapping(value = APP_ROOT + "/fournisseurs/update/{idFournisseur}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Fournisseur> update(@PathVariable("idFournisseur") Long id, @RequestBody Fournisseur fournisseur);

    @GetMapping(value = APP_ROOT + "/fournisseurs/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Fournisseur> findById(@PathVariable("idFournisseur") Long id);

    @GetMapping(value = APP_ROOT + "/fournisseurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Fournisseur> findAll();

    @DeleteMapping(value = APP_ROOT + "/fournisseurs/delete/{idFournisseur}")
    void delete(@PathVariable("idFournisseur") Long id);
}
