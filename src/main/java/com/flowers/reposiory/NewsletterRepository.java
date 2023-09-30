package com.flowers.reposiory;

import com.flowers.models.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Long> {

    @Query("select count(p) from Newsletter p where p.actif=1")
    BigDecimal countNumberOfNewsletters();

    @Query("Select DISTINCT act from Newsletter act where act.actif=1 ORDER BY act.id desc")
    List<Newsletter> findAll();
}
