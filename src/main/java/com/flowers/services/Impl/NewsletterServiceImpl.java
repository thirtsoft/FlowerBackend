package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Newsletter;
import com.flowers.reposiory.NewsletterRepository;
import com.flowers.services.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NewsletterServiceImpl implements NewsletterService {

    private final NewsletterRepository newsletterRepository;

    @Autowired
    public NewsletterServiceImpl(NewsletterRepository newsletterRepository) {
        this.newsletterRepository = newsletterRepository;
    }

    @Override
    public Newsletter save(Newsletter newsletter) {
        return newsletterRepository.save(newsletter);
    }

    @Override
    public Optional<Newsletter> findById(Long id) {
        if (!newsletterRepository.existsById(id)) {
            throw new ResourceNotFoundException("Newsletter that id is " + id + "not found");
        }
        return newsletterRepository.findById(id);
    }

    @Override
    public List<Newsletter> findAll() {
        return newsletterRepository.findAll();
    }

    @Override
    public List<Newsletter> findByOrderByIdDesc() {
        return newsletterRepository.findByOrderByIdDesc();
    }

    @Override
    public BigDecimal countNumberOfNewsletters() {
        return newsletterRepository.countNumberOfNewsletters();
    }

    @Override
    public void delete(Long id) {
        if (!newsletterRepository.existsById(id)) {
            throw new ResourceNotFoundException("Newsletter that id is " + id + "not found");
        }
        newsletterRepository.deleteById(id);

    }
}
