package com.flowers.controllers;

import com.flowers.controllers.api.EmailApi;
import com.flowers.dtos.EmailDto;
import com.flowers.dtos.FournisseurDto;
import com.flowers.dtos.NewsletterDto;
import com.flowers.dtos.UtilisateurDto;
import com.flowers.services.EmailService;
import com.flowers.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"https://fleurpourtous.com", "https://portail.fleurpourtous.com"})
//@CrossOrigin
@RestController
public class EmailController implements EmailApi {

    private final EmailService emailService;

    private final UtilisateurService utilisateurService;

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailController(EmailService emailService, UtilisateurService utilisateurService, JavaMailSender javaMailSender) {
        this.emailService = emailService;
        this.utilisateurService = utilisateurService;
        this.javaMailSender = javaMailSender;
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
    public ResponseEntity<String> sendConfirmOrderedToManager(Long id) {
        UtilisateurDto optionalUtilisateur = utilisateurService.findUtilisateurById(id);
        SimpleMailMessage mail = new SimpleMailMessage();
    //    mail.setFrom("thirdiallo@gmail.com");
        mail.setTo("thirdiallo@gmail.com");
        mail.setSubject("Une commande est passé sur la plateforme mafleur.com");
        mail.setText("M ou Mme "+optionalUtilisateur.getName()+","+"\r\n" +
                "\r\n" +
                "A effectué une commande sur la plateforme mafleur.com.\r\n" +
                "\r\n" +
                "A la date du "+ new Date()+" delai.\r\n" +
                "\r\n" +
                "Nous sommes heureux de vous compter parmi nos clients .\r\n" +
                "\r\n" +
                "Merci de votre confaince !!!.\r\n" +
                "\r\n" +
                "A bientot,");
        javaMailSender.send(mail);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> sendConfirmOrderedToCustomer(Long id) {
        UtilisateurDto optionalUtilisateur = utilisateurService.findUtilisateurById(id);
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("thirdiallo@gmail.com");
        mail.setTo(optionalUtilisateur.getEmail());
        mail.setSubject("Votre commande sur la plateforme mafleur.com");
        mail.setText("Cher "+optionalUtilisateur.getName()+","+"\r\n" +
                "\r\n" +
                "Nous avons bien reçu commande.\r\n" +
                "\r\n" +
                "Nous précéderons à la livraison de votre commande, une fois le payement effectué dans les brefs delai.\r\n" +
                "\r\n" +
                "Nous sommes heureux de vous compter parmi nos clients .\r\n" +
                "\r\n" +
                "Merci de votre confaince !!!.\r\n" +
                "\r\n" +
                "A bientot,");
        javaMailSender.send(mail);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<FournisseurDto> sendMailToProvider(FournisseurDto fournisseurDto) {
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

    @Override
    public ResponseEntity<List<EmailDto>> getAllActiveEmails() {
        List<EmailDto> emailDtoList = emailService.findAllActiveEmails();
        return new ResponseEntity<>(emailDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteEmail(Long idEmail) {
        emailService.deleteEmail(idEmail);
    }
}
