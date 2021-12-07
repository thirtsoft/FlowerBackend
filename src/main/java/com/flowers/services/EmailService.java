package com.flowers.services;

import com.flowers.models.Email;
import com.flowers.models.Fournisseur;
import com.flowers.models.Newsletter;
import org.springframework.mail.MailException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface EmailService {

    void sendEmailToManager(Email email) throws MailException;

    void sendEmailToProvider(Fournisseur fournisseur) throws MailException;

    void sendEmailToNewsletter(Newsletter newsletter) throws MailException;

    void sendMailToAllNewsletters(Newsletter newsletter);

    Optional<Email> findEmailById(Long mailId);

    BigDecimal countNumberOfEmailInMonth();

    List<Email> findAll();

    List<Email> findByOrderByIdDesc();

    void delete(Long id);
}
