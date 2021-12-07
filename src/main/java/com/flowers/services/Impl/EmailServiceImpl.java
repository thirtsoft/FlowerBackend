package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Email;
import com.flowers.models.Fournisseur;
import com.flowers.models.Newsletter;
import com.flowers.reposiory.EmailRepository;
import com.flowers.services.EmailService;
import com.flowers.services.NewsletterService;
import com.flowers.utils.EmailConstants;
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

@Service
@Transactional
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
    public void sendEmailToManager(Email email) throws MailException {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom : " + email.getCustomerName()).append(System.lineSeparator());
        sb.append("\n Subject : " + email.getSubject());
        sb.append("\n Message : " + email.getMessage());

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(EmailConstants.to);
        mail.setFrom(email.getRecipient());
        mail.setSubject(email.getSubject());
        mail.setText(email.getMessage());

        email.setCreateDate(new Date());
        email.setCustomerName(email.getCustomerName());

        System.out.println(email);

        javaMailSender.send(mail);

        emailRepository.save(email);

    }

    @Override
    public void sendEmailToProvider(Fournisseur fournisseur) throws MailException {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom : " + EmailConstants.managerName).append(System.lineSeparator());
        sb.append("\n Subject : " + fournisseur.getSubject());
        sb.append("\n Message : " + fournisseur.getMessage());

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(fournisseur.getEmail());
        mail.setFrom(EmailConstants.from);
        mail.setSubject(fournisseur.getSubject());
        mail.setText(fournisseur.getMessage());

        javaMailSender.send(mail);
    }

    @Override
    public void sendEmailToNewsletter(Newsletter newsletter) throws MailException {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom : " + EmailConstants.managerName).append(System.lineSeparator());
        sb.append("\n Subject : " + newsletter.getSubject());
        sb.append("\n Message : " + newsletter.getMessage());

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(newsletter.getCustomerEmail());
        mail.setFrom(EmailConstants.from);
        mail.setSubject(newsletter.getSubject());
        mail.setText(newsletter.getMessage());


        javaMailSender.send(mail);
    }

    @Override
    public void sendMailToAllNewsletters(Newsletter newsletter) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom : " + EmailConstants.managerName).append(System.lineSeparator());
        sb.append("\n Subject : " + newsletter.getSubject());
        sb.append("\n Message : " + newsletter.getMessage());

        List<Newsletter> newsletterList = newsletterService.findAll();

        SimpleMailMessage mail = new SimpleMailMessage();

        for (int i = 0; i < newsletterList.size(); i++) {
            Newsletter newsletterResult = newsletterList.get(i);
            mail.setTo(newsletterResult.getCustomerEmail());
            mail.setSubject(newsletterResult.getSubject());
            mail.setText(newsletterResult.getMessage());
            mail.setFrom(EmailConstants.from);
        }

        javaMailSender.send(mail);
    }

    @Override
    public Optional<Email> findEmailById(Long mailId) {
        if (!emailRepository.existsById(mailId)) {
            throw new ResourceNotFoundException("Email that id is " + mailId + "not found");
        }
        return emailRepository.findById(mailId);
    }

    @Override
    public BigDecimal countNumberOfEmailInMonth() {
        return emailRepository.countNumberOfEmail();
    }

    @Override
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public List<Email> findByOrderByIdDesc() {
        return emailRepository.findByOrderByIdDesc();
    }

    @Override
    public void delete(Long id) {
        if (!emailRepository.existsById(id)) {
            throw new ResourceNotFoundException("Email that id is " + id + "not found");
        }
        emailRepository.deleteById(id);
    }
}
