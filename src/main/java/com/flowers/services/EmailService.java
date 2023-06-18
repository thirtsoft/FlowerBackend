package com.flowers.services;

import com.flowers.dtos.CountryDto;
import com.flowers.dtos.EmailDto;
import com.flowers.dtos.FournisseurDto;
import com.flowers.dtos.NewsletterDto;
import org.springframework.mail.MailException;

import java.math.BigDecimal;
import java.util.List;

public interface EmailService {

    void sendEmailToManager(EmailDto emailDto) throws MailException;

    void sendEmailConfirmation(EmailDto emailDto) throws MailException;

    void sendEmailToProvider(FournisseurDto fournisseurDto) throws MailException;

    void sendEmailToNewsletter(NewsletterDto newsletterDto) throws MailException;

    void sendMailToAllNewsletters(NewsletterDto newsletterDto);

    EmailDto findEmailById(Long mailId);

    BigDecimal countNumberOfEmailInMonth();

    List<EmailDto> findAll();

    List<EmailDto> findByOrderByIdDesc();

    void delete(Long id);

    List<EmailDto> findAllActiveEmails();

    void deleteEmail(Long mailId);
}
