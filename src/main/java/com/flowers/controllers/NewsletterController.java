package com.flowers.controllers;

import com.flowers.controllers.api.NewsletterApi;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Newsletter;
import com.flowers.services.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
public class NewsletterController implements NewsletterApi {

    private final NewsletterService newsletterService;

    @Autowired
    public NewsletterController(NewsletterService newsletterService) {
        this.newsletterService = newsletterService;
    }

    @Override
    public ResponseEntity<Newsletter> save(Newsletter newsletter) {
        return ResponseEntity.ok(newsletterService.save(newsletter));
    }

    @Override
    public ResponseEntity<Newsletter> getNewsletterById(Long id) throws ResourceNotFoundException {
        Newsletter newsletter = newsletterService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Newsletter not found"));
        return ResponseEntity.ok().body(newsletter);
    }

    @Override
    public ResponseEntity<List<Newsletter>> findAll() {
        List<Newsletter> newsletterList = newsletterService.findAll();
        return new ResponseEntity<>(newsletterList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Newsletter>> getAllNewslettersOrderByIdDesc() {
        List<Newsletter> newsletterList = newsletterService.findByOrderByIdDesc();
        return new ResponseEntity<>(newsletterList, HttpStatus.OK);
    }

    @Override
    public BigDecimal countNumberOfNewsletter() {
        return newsletterService.countNumberOfNewsletters();
    }

    @Override
    public void delete(Long id) {
        newsletterService.delete(id);
    }
}
