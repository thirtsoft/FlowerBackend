package com.flowers.reposiory;

import com.flowers.models.Email;
import com.flowers.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    @Query("select count(*) from Fournisseur")
    BigDecimal countNumberOfFournisseur();

    List<Fournisseur> findByOrderByIdDesc();

    @Query("Select DISTINCT act from Fournisseur act where act.actif=1 ORDER BY act.id desc ")
    List<Fournisseur> findAll();

}
