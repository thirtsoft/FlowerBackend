package com.flowers.controllers.api;

import com.flowers.dtos.EmailDto;
import com.flowers.dtos.FournisseurDto;
import com.flowers.dtos.NewsletterDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

@RequestMapping(value = APP_ROOT + "/emails")
public interface EmailApi {

    @PostMapping(value = "/send-mail-to-manager")
    @ApiOperation(value = "Envoyer un email au Manager du site",
            notes = "Cette méthode permet d'envoyer un email au Manager du site",
            response = EmailDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'email a été envoyé / modifié"),
            @ApiResponse(code = 400, message = "Aucun Email  envoyé")
    })
    ResponseEntity<EmailDto> sendEmailToManager(@RequestBody EmailDto emailDto);

    @GetMapping(value = "/send-confirm-order-to-manager/{id}")
    @ApiOperation(value = "Envoyer un email de confirmation de commande au Manager du site",
            notes = "Cette méthode permet d'envoyer un email au Manager du site",
            response = EmailDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'email a été envoyé / modifié"),
            @ApiResponse(code = 400, message = "Aucun Email  envoyé")
    })
    ResponseEntity<String> sendConfirmOrderedToManager(@PathVariable("id") Long id);

    @GetMapping(value = "/send-confirm-ordered-to-customer/{id}")
    @ApiOperation(value = "Envoyer un email de confirmation de commande au Manager du site",
            notes = "Cette méthode permet d'envoyer un email au Manager du site",
            response = EmailDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'email a été envoyé / modifié"),
            @ApiResponse(code = 400, message = "Aucun Email  envoyé")
    })
    ResponseEntity<String> sendConfirmOrderedToCustomer(@PathVariable("id") Long id);


    @PostMapping(value = "/send-to-fournisseur")
    @ApiOperation(value = "Envoyer un email à un Fournisseurs",
            notes = "Cette méthode permet d'envoyer un email à un Fournisseurs",
            response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'email a été envoyé / modifié"),
            @ApiResponse(code = 400, message = "Aucun Email  envoyé")
    })
    ResponseEntity<FournisseurDto> sendMailToProvider(@RequestBody FournisseurDto fournisseurDto);

    @PostMapping(value = "/send-to-newsletter")
    @ApiOperation(value = "Envoyer un email à un client",
            notes = "Cette méthode permet d'envoyer un email à un client",
            response = NewsletterDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'email a été envoyé / modifié"),
            @ApiResponse(code = 400, message = "Aucun Email  envoyé")
    })
    ResponseEntity<NewsletterDto> sendMailToCustomer(@RequestBody NewsletterDto newsletterDto);

    @PostMapping(value = "/send-mail-to-all-customers")
    @ApiOperation(value = "Envoyer un email à plusieurs Clients",
            notes = "Cette méthode permet d'envoyer un email à plusieurs Clients",
            response = NewsletterDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'email a été envoyé / modifié"),
            @ApiResponse(code = 400, message = "Aucun Email  envoyé")
    })
    ResponseEntity<EmailDto> sendMailToAllCustomers(@RequestBody EmailDto newsletterDto);

    @GetMapping(value = "/count-number-of-email", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Email dans le moi",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Email")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Email / le nombre est nulle")
    })
    BigDecimal countNumberOfEmail();

    @GetMapping(value = "/search-all-active-emails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des emails actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des emails actives",
            responseContainer = "List<CountryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des emails par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<EmailDto>> getAllActiveEmails();

    @DeleteMapping(value = "/delete-email/{idEmail}")
    @ApiOperation(value = "Supprimer un email par son ID",
            notes = "Cette méthode permet de supprimer un email  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le email a été supprimé")
    })
    void deleteEmail(@PathVariable("idEmail") Long idEmail);
}
