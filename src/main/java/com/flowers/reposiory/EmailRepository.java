package com.flowers.reposiory;

import com.flowers.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    @Query("select count(p) from Email p where p.actif=1 and month(p.createDate) = month(current_date)")
    BigDecimal countNumberOfEmail();

    @Query("Select DISTINCT act from Email act where act.actif=1 ORDER BY act.id desc ")
    List<Email> findAll();
}
