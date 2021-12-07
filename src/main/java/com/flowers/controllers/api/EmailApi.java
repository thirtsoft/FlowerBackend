package com.flowers.controllers.api;

import com.flowers.models.Email;
import com.flowers.models.Fournisseur;
import com.flowers.models.Newsletter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface EmailApi {

    @PostMapping(value = APP_ROOT + "/emails/sendMailToManager")
    @ApiOperation(value = "Envoyer un email au Manager du site",
            notes = "Cette méthode permet d'envoyer un email au Manager du site",
            response = Email.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'email a été envoyé / modifié"),
            @ApiResponse(code = 400, message = "Aucun Email  envoyé")
    })
    ResponseEntity<Email> sendEmailToManager(@RequestBody Email email);


    @PostMapping(value = APP_ROOT + "/emails/sendToFournisseur")
    @ApiOperation(value = "Envoyer un email à un Fournisseurs",
            notes = "Cette méthode permet d'envoyer un email à un Fournisseurs",
            response = Fournisseur.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'email a été envoyé / modifié"),
            @ApiResponse(code = 400, message = "Aucun Email  envoyé")
    })
    ResponseEntity<Fournisseur> sendMailToFournisseur(@RequestBody Fournisseur fournisseur);

    @PostMapping(value = APP_ROOT + "/emails/sendToNewsletter")
    @ApiOperation(value = "Envoyer un email à un client",
            notes = "Cette méthode permet d'envoyer un email à un client",
            response = Email.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'email a été envoyé / modifié"),
            @ApiResponse(code = 400, message = "Aucun Email  envoyé")
    })
    ResponseEntity<Newsletter> sendMailToCustomer(@RequestBody Newsletter newsletter);

    @PostMapping(value = APP_ROOT + "/emails/sendMailToAllCustomers")
    @ApiOperation(value = "Envoyer un email à plusieurs Clients",
            notes = "Cette méthode permet d'envoyer un email à plusieurs Clients",
            response = Email.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'email a été envoyé / modifié"),
            @ApiResponse(code = 400, message = "Aucun Email  envoyé")
    })
    ResponseEntity<Newsletter> sendMailToAllCustomers(@RequestBody Newsletter newsletter);


    @GetMapping(value = APP_ROOT + "/emails/findById/{idEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un Email par ID",
            notes = "Cette méthode permet de chercher un Email par son ID", response = Email.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Email a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Email n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<Email> getEmailById(@PathVariable("idEmail") Long id);

    @GetMapping(value = APP_ROOT + "/emails/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Email",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Email", responseContainer = "List<Email>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Email / une liste vide")
    })
    ResponseEntity<List<Email>> getAllEmails();

    @GetMapping(value = APP_ROOT + "/emails/searchAllEmailsOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Emails par ordre descroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Emails par ordre descroissante",
            responseContainer = "List<Email>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Emails  par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<Email>> getAllEmailOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/emails/countNumberOfEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Email dans le moi",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Email")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Email / le nombre est nulle")
    })
    BigDecimal countNumberOfEmail();

    @DeleteMapping(value = APP_ROOT + "/emails/delete/{idEmail}")
    @ApiOperation(value = "Supprimer un Email par son ID",
            notes = "Cette méthode permet de supprimer une Email par son ID", response = Email.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Notification a été supprimé")
    })
    void delete(@PathVariable("idEmail") Long id);
}
