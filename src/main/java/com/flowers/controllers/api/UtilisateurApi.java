package com.flowers.controllers.api;

import com.flowers.models.Utilisateur;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT + "/utilisateurs/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Utilisateur> save(@RequestBody Utilisateur utilisateur);

    @PutMapping(value = APP_ROOT + "/utilisateurs/update/{idUtilisateur}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Utilisateur> update(@PathVariable("idUtilisateur") Long id, @RequestBody Utilisateur utilisateur);

    @GetMapping(value = APP_ROOT + "/utilisateurs/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Utilisateur> findById(@PathVariable("idUtilisateur") Long id);

    @GetMapping(value = APP_ROOT + "/utilisateurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Utilisateur> findAll();

    @DeleteMapping(value = APP_ROOT + "/utilisateurs/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Long id);
}
