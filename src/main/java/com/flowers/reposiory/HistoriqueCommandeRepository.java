package com.flowers.reposiory;

import com.flowers.models.Fournisseur;
import com.flowers.models.HistoriqueCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface HistoriqueCommandeRepository extends JpaRepository<HistoriqueCommande, Long> {

    @Query("select count(f) from HistoriqueCommande f ")
    BigDecimal countNumberOfHistoriqueCommandes();

    List<HistoriqueCommande> findByOrderByIdDesc();

    @Query("Select DISTINCT act from HistoriqueCommande act where act.actif=1 ORDER BY act.id desc ")
    List<HistoriqueCommande> findAll();

}
