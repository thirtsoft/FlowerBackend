package com.flowers.services;

import com.flowers.dtos.NewsletterDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface NewsletterService {

    NewsletterDto save(NewsletterDto newsletterDto);

    NewsletterDto findById(Long id);

    List<NewsletterDto> findAll();

    List<NewsletterDto> findByOrderByIdDesc();

    BigDecimal countNumberOfNewsletters();

    void delete(Long id);
}
