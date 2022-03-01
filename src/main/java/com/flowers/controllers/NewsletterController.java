package com.flowers.controllers;

import com.flowers.controllers.api.NewsletterApi;
import com.flowers.dtos.NewsletterDto;
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
    public ResponseEntity<NewsletterDto> saveNewsletter(NewsletterDto newsletterDto) {
        NewsletterDto newsletterDtoResult = newsletterService.save(newsletterDto);
        return new ResponseEntity<>(newsletterDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<NewsletterDto> getNewsletterById(Long id) {
        NewsletterDto newsletterDtoResult = newsletterService.findById(id);
        return new ResponseEntity<>(newsletterDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<NewsletterDto>> getAllNewsletters() {
        List<NewsletterDto> newsletterDtoList = newsletterService.findAll();
        return new ResponseEntity<>(newsletterDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<NewsletterDto>> getAllNewslettersOrderByIdDesc() {
        List<NewsletterDto> newsletterDtoList = newsletterService.findByOrderByIdDesc();
        return new ResponseEntity<>(newsletterDtoList, HttpStatus.OK);
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
