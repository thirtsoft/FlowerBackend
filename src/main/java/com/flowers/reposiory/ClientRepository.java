package com.flowers.reposiory;

import com.flowers.models.Category;
import com.flowers.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select count(p) from Client p ")
    BigDecimal countNumberOfClient();

    List<Client> findByOrderByIdDesc();

    @Query("Select DISTINCT act from Client act where act.actif=1 ORDER BY act.id desc")
    List<Client> findAll();
}
