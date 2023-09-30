package com.flowers.services.Impl;

import com.flowers.dtos.NewsletterDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Newsletter;
import com.flowers.reposiory.NewsletterRepository;
import com.flowers.services.NewsletterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class NewsletterServiceImpl implements NewsletterService {

    private final NewsletterRepository newsletterRepository;

    @Autowired
    public NewsletterServiceImpl(NewsletterRepository newsletterRepository) {
        this.newsletterRepository = newsletterRepository;
    }

    @Override
    public NewsletterDto save(NewsletterDto newsletterDto) {
        newsletterDto.setActif(true);
        return NewsletterDto.fromEntityToDto(
                newsletterRepository.save(
                        NewsletterDto.fromDtoToEntity(newsletterDto)
                )
        );
    }

    @Override
    public BigDecimal countNumberOfNewsletters() {
        return newsletterRepository.countNumberOfNewsletters();
    }

    @Override
    public List<NewsletterDto> findAllActiveNewsletters() {
        return newsletterRepository.findAll().stream()
                .map(NewsletterDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteNewsletter(Long newId) {
        if (newId == null) {
            log.error("Newsletter not found");
            return;
        }
        Newsletter newsletter = newsletterRepository.findById(newId).get();
        newsletter.setActif(false);
        newsletterRepository.save(newsletter);
    }
}
