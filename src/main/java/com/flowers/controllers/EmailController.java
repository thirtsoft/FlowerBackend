package com.flowers.controllers;

import com.flowers.controllers.api.EmailApi;
import com.flowers.dtos.EmailDto;
import com.flowers.dtos.FournisseurDto;
import com.flowers.dtos.NewsletterDto;
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
        try {
            emailDto.setCreateDate(new Date());
            emailService.sendEmailToManager(emailDto);
            return new ResponseEntity<>(emailDto, HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<FournisseurDto> sendMailToFournisseur(FournisseurDto fournisseurDto) {
        try {
            emailService.sendEmailToProvider(fournisseurDto);
            return new ResponseEntity<>(fournisseurDto, HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<NewsletterDto> sendMailToCustomer(NewsletterDto newsletterDto) {
        try {
            emailService.sendEmailToNewsletter(newsletterDto);
            return new ResponseEntity<>(newsletterDto, HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<NewsletterDto> sendMailToAllCustomers(NewsletterDto newsletterDto) {
        try {
            emailService.sendMailToAllNewsletters(newsletterDto);
            return new ResponseEntity<>(newsletterDto, HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<EmailDto> getEmailById(Long id) {
        EmailDto emailDto = emailService.findEmailById(id);
        return new ResponseEntity<>(emailDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EmailDto>> getAllEmails() {
        List<EmailDto> emailDtoList = emailService.findAll();
        return new ResponseEntity(emailDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EmailDto>> getAllEmailOrderByIdDesc() {
        List<EmailDto> emailDtoList = emailService.findByOrderByIdDesc();
        return new ResponseEntity(emailDtoList, HttpStatus.OK);
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
