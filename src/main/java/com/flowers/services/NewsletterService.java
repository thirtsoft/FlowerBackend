package com.flowers.services;

import com.flowers.models.Fournisseur;
import com.flowers.models.Newsletter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface NewsletterService {

    Newsletter save(Newsletter newsletter);

    Optional<Newsletter> findById(Long id);

    List<Newsletter> findAll();

    List<Newsletter> findByOrderByIdDesc();

    BigDecimal countNumberOfNewsletters();

    void delete(Long id);
}
