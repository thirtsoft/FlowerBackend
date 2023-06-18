package com.flowers.reposiory;

import com.flowers.models.Country;
import com.flowers.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    @Query("select count(p) from Email p where month(p.createDate) = month(current_date)")
    BigDecimal countNumberOfEmail();

    List<Email> findByOrderByIdDesc();

    @Query("Select DISTINCT act from Email act where act.actif=1 ORDER BY act.id desc ")
    List<Email> findAll();
}
