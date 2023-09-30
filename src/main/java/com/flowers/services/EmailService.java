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

    void sendEmailToProvider(FournisseurDto emailDto) throws MailException;

    void sendEmailToNewsletter(NewsletterDto emailDto) throws MailException;

    void sendMailToAllNewsletters(EmailDto emailDto);

    BigDecimal countNumberOfEmailInMonth();

    List<EmailDto> findAllActiveEmails();

    void deleteEmail(Long mailId);
}
