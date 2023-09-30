package com.flowers.services;

import com.flowers.dtos.NewsletterDto;

import java.math.BigDecimal;
import java.util.List;

public interface NewsletterService {

    NewsletterDto save(NewsletterDto newsletterDto);

    BigDecimal countNumberOfNewsletters();

    List<NewsletterDto> findAllActiveNewsletters();

    void deleteNewsletter(Long newId);
}
