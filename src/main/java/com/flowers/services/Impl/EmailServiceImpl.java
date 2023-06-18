package com.flowers.services.Impl;

import com.flowers.dtos.EmailDto;
import com.flowers.dtos.FournisseurDto;
import com.flowers.dtos.NewsletterDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Email;
import com.flowers.reposiory.EmailRepository;
import com.flowers.services.EmailService;
import com.flowers.services.NewsletterService;
import com.flowers.utils.EmailConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    private final JavaMailSender javaMailSender;

    private final NewsletterService newsletterService;

    @Autowired
    public EmailServiceImpl(EmailRepository emailRepository,
                            JavaMailSender javaMailSender,
                            NewsletterService newsletterService) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
        this.newsletterService = newsletterService;
    }


    @Override
    public void sendEmailToManager(EmailDto emailDto) throws MailException {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom : " + emailDto.getCustomerName()).append(System.lineSeparator());
        sb.append("\n Subject : " + emailDto.getSubject());
        sb.append("\n Message : " + emailDto.getMessage());

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(EmailConstants.to);
        mail.setFrom(emailDto.getRecipient());
        mail.setSubject(emailDto.getSubject());
        mail.setText(emailDto.getMessage());

        emailDto.setCreateDate(new Date());
        emailDto.setCustomerName(emailDto.getCustomerName());
        emailDto.setActif(true);

        System.out.println(emailDto);

        //    javaMailSender.send(mail);

        EmailDto.fromEntityToDto(
                emailRepository.save(
                        EmailDto.fromDtoToEntity(emailDto)
                )
        );
    }

    @Override
    public void sendEmailConfirmation(EmailDto emailDto) throws MailException {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom : " + emailDto.getCustomerName()).append(System.lineSeparator());
        sb.append("\n Subject : " + emailDto.getSubject());
        sb.append("\n Message : " + emailDto.getMessage());

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(EmailConstants.to);
        mail.setFrom(emailDto.getRecipient());
        mail.setSubject(emailDto.getSubject());
        mail.setText(emailDto.getMessage());

        emailDto.setCreateDate(new Date());
        emailDto.setCustomerName(emailDto.getCustomerName());
        emailDto.setActif(true);

        System.out.println(emailDto);

        javaMailSender.send(mail);

    }

    @Override
    public void sendEmailToProvider(FournisseurDto fournisseurDto) throws MailException {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom : " + EmailConstants.managerName).append(System.lineSeparator());
        sb.append("\n Subject : " + fournisseurDto.getSubject());
        sb.append("\n Message : " + fournisseurDto.getMessage());

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(fournisseurDto.getEmail());
        mail.setFrom(EmailConstants.from);
        mail.setSubject(fournisseurDto.getSubject());
        mail.setText(fournisseurDto.getMessage());


        javaMailSender.send(mail);
    }

    @Override
    public void sendEmailToNewsletter(NewsletterDto newsletterDto) throws MailException {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom : " + EmailConstants.managerName).append(System.lineSeparator());
        sb.append("\n Subject : " + newsletterDto.getSubject());
        sb.append("\n Message : " + newsletterDto.getMessage());

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(newsletterDto.getCustomerEmail());
        mail.setFrom(EmailConstants.from);
        mail.setSubject(newsletterDto.getSubject());
        mail.setText(newsletterDto.getMessage());

        javaMailSender.send(mail);
    }

    @Override
    public void sendMailToAllNewsletters(NewsletterDto newsletterDto) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom : " + EmailConstants.managerName).append(System.lineSeparator());
        sb.append("\n Subject : " + newsletterDto.getSubject());
        sb.append("\n Message : " + newsletterDto.getMessage());

        List<NewsletterDto> newsletterDtos = newsletterService.findAll();

        SimpleMailMessage mail = new SimpleMailMessage();

        for (int i = 0; i < newsletterDtos.size(); i++) {
            NewsletterDto newsletterDtoResult = newsletterDtos.get(i);
            mail.setTo(newsletterDtoResult.getCustomerEmail());
            mail.setSubject(newsletterDtoResult.getSubject());
            mail.setText(newsletterDtoResult.getMessage());
            mail.setFrom(EmailConstants.from);
        }

        javaMailSender.send(mail);
    }

    @Override
    public EmailDto findEmailById(Long mailId) {
        if (mailId == null) {
            log.error("mail Id is null");
            return null;
        }

        Optional<Email> optionalEmail = emailRepository.findById(mailId);

        return Optional.of(EmailDto.fromEntityToDto(optionalEmail.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun Email avec l'Id = " + mailId + "n'a été trouvé")
        );
    }

    @Override
    public BigDecimal countNumberOfEmailInMonth() {
        return emailRepository.countNumberOfEmail();
    }

    @Override
    public List<EmailDto> findAll() {
        return emailRepository.findAll().stream()
                .map(EmailDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmailDto> findByOrderByIdDesc() {
        return emailRepository.findByOrderByIdDesc().stream()
                .map(EmailDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Email avec cet id existe pas !!");
            return;
        }
        emailRepository.deleteById(id);
    }

    @Override
    public List<EmailDto> findAllActiveEmails() {
        return emailRepository.findAll().stream()
                .map(EmailDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmail(Long mailId) {
        if (mailId == null) {
            log.error("Email avec cet id existe pas !!");
            return;
        }
        Email email = emailRepository.findById(mailId).get();
        email.setActif(false);
        emailRepository.save(email);
    }
}
