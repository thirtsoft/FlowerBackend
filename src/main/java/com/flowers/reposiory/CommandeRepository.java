package com.flowers.reposiory;

import com.flowers.models.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

    @Query("select count(p) from Commande p ")
    BigDecimal countNumberOfOrder();

    @Query("select count(c) from Commande c where month(c.dateCommande) = month(current_date)")
    BigDecimal countNumberOfOrdersInMonth();

    @Query("select count(c) from Commande c where c.status = 'ENCOURS' ")
    BigDecimal countNumberOfOrdersByStatusPending();

    @Query("select sum(c.totalCommande) from Commande c where c.dateCommande > current_date")
    BigDecimal sumTotalOfOrderByDay();

    @Query("select sum(c.totalCommande) from Commande c where month(c.dateCommande) = month(current_date)")
    BigDecimal sumTotalOfOrdersByMonth();

    @Query("select sum(c.totalCommande) from Commande c where month(c.dateCommande) = month(current_date)")
    BigDecimal sumTotaleOfOrderByMonth();

    @Query("select sum(c.totalCommande) from Commande c where year(c.dateCommande) = year(current_date)")
    BigDecimal sumTotalOfOrdersByYear();

    @Query("select c from Commande c where c.status = 'ENCOURS' order by id Desc ")
    List<Commande> findListOrderByStatusPending();

    @Query("select c from Commande c where c.status = 'PAYEE' order by id Desc ")
    List<Commande> findListOrderByStatusPayed();

    List<Commande> findByOrderByIdDesc();

    @Query("select EXTRACT(day from(c.dateCommande)), count(c) from Commande c group by EXTRACT(day from(c.dateCommande))")
    List<?> countNumberOfOrderByDay();

    @Query("select EXTRACT(month from(c.dateCommande)), count(c) from Commande c group by EXTRACT(month from(c.dateCommande))")
    List<?> countNumberOfOrderByMonth();

    @Query("select EXTRACT(month from(c.dateCommande)), sum(c.totalCommande) from Commande c group by EXTRACT(month from(c.dateCommande))")
    List<?> sumTotalOfOrderByMonth();

    @Query("select EXTRACT(year from(v.dateCommande)), sum(v.totalCommande) from Commande v group by EXTRACT(year from(v.dateCommande))")
    List<?> sumTotalOfOrderByYears();

    @Query("select p from Commande p where p.utilisateur.id =:user order by id Desc")
    List<Commande> ListOrderByCustomerId(@Param("user") Long userId);

    @Query("select p from Commande p where p.shippingAddress.id =:addLivraison order by id Desc")
    List<Commande> ListOrderByAddressLivraisonId(@Param("addLivraison") Long addLivraison);

    @Query("select p from Commande p where p.billingAddress.id =:addAchat order by id Desc")
    List<Commande> ListOrderByAddressAchatId(@Param("addAchat") Long addAchat);

    @Query("select com from Commande com where com.utilisateur.id =:userId")
    Page<Commande> findOrderByUtilisateurPageables(@Param("userId") Long userId, Pageable pageable);

}
