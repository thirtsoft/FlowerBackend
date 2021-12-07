package com.flowers.controllers;

import com.flowers.controllers.api.EmailApi;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Email;
import com.flowers.models.Fournisseur;
import com.flowers.models.Newsletter;
import com.flowers.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class EmailController implements EmailApi {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public ResponseEntity<Email> sendEmailToManager(Email email) {
        try {
            email.setCreateDate(new Date());
            emailService.sendEmailToManager(email);
            return new ResponseEntity<>(email, HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Fournisseur> sendMailToFournisseur(Fournisseur fournisseur) {
        try {
            emailService.sendEmailToProvider(fournisseur);
            return new ResponseEntity<>(fournisseur, HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Newsletter> sendMailToCustomer(Newsletter newsletter) {
        try {
            emailService.sendEmailToNewsletter(newsletter);
            return new ResponseEntity<>(newsletter, HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Newsletter> sendMailToAllCustomers(Newsletter newsletter) {
        try {
            emailService.sendMailToAllNewsletters(newsletter);
            return new ResponseEntity<>(newsletter, HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Email> getEmailById(Long id) {
        Email email = emailService.findEmailById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Email not found"));
        return ResponseEntity.ok().body(email);
    }

    @Override
    public ResponseEntity<List<Email>> getAllEmails() {
        List<Email> emailList = emailService.findAll();
        return new ResponseEntity<>(emailList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Email>> getAllEmailOrderByIdDesc() {
        List<Email> emailList = emailService.findByOrderByIdDesc();
        return new ResponseEntity<>(emailList, HttpStatus.OK);
    }

    @Override
    public BigDecimal countNumberOfEmail() {
        return emailService.countNumberOfEmailInMonth();
    }

    @Override
    public void delete(Long id) {
        emailService.delete(id);
    }
}
