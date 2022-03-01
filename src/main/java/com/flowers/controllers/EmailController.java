package com.flowers.controllers;

import com.flowers.controllers.api.EmailApi;
import com.flowers.dtos.EmailDto;
import com.flowers.dtos.FournisseurDto;
import com.flowers.dtos.NewsletterDto;
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
    public ResponseEntity<EmailDto> sendEmailToManager(EmailDto emailDto) {
        return null;
    }

    @Override
    public ResponseEntity<FournisseurDto> sendMailToFournisseur(FournisseurDto fournisseurDto) {
        return null;
    }

    @Override
    public ResponseEntity<NewsletterDto> sendMailToCustomer(NewsletterDto newsletterDto) {
        return null;
    }

    @Override
    public ResponseEntity<NewsletterDto> sendMailToAllCustomers(NewsletterDto newsletterDto) {
        return null;
    }

    @Override
    public ResponseEntity<EmailDto> getEmailById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<EmailDto>> getAllEmails() {
        return null;
    }

    @Override
    public ResponseEntity<List<EmailDto>> getAllEmailOrderByIdDesc() {
        return null;
    }

    @Override
    public BigDecimal countNumberOfEmail() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
