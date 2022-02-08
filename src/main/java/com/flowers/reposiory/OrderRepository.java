package com.flowers.reposiory;

import com.flowers.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select count(p) from Order p ")
    BigDecimal countNumberOfOrder();

    @Query("select count(c) from Order c where month(c.orderDate) = month(current_date)")
    BigDecimal countNumberOfOrdersInMonth();

    @Query("select count(c) from Order c where c.status = 'ENCOURS' ")
    BigDecimal countNumberOfOrdersByStatusPending();

    @Query("select sum(c.totalPrice) from Order c where c.orderDate > current_date")
    BigDecimal sumTotalOfOrderByDay();

    @Query("select sum(c.totalPrice) from Order c where month(c.orderDate) = month(current_date)")
    BigDecimal sumTotalOfOrdersByMonth();

    @Query("select sum(c.totalPrice) from Order c where month(c.orderDate) = month(current_date)")
    BigDecimal sumTotaleOfOrderByMonth();

    @Query("select sum(c.totalPrice) from Order c where year(c.orderDate) = year(current_date)")
    BigDecimal sumTotalOfOrdersByYear();

    @Query("select c from Order c where c.status = 'ENCOURS' order by id Desc ")
    List<Order> findListOrderByStatusPending();

    @Query("select c from Order c where c.status = 'PAYEE' order by id Desc ")
    List<Order> findListOrderByStatusPayed();

    List<Order> findByOrderByIdDesc();

    @Query("select EXTRACT(day from(c.orderDate)), count(c) from Order c group by EXTRACT(day from(c.orderDate))")
    List<?> countNumberOfOrderByDay();

    @Query("select EXTRACT(month from(c.orderDate)), count(c) from Order c group by EXTRACT(month from(c.orderDate))")
    List<?> countNumberOfOrderByMonth();

    @Query("select EXTRACT(month from(c.orderDate)), sum(c.totalPrice) from Order c group by EXTRACT(month from(c.orderDate))")
    List<?> sumTotalOfOrderByMonth();

    @Query("select EXTRACT(year from(v.orderDate)), sum(v.totalPrice) from Order v group by EXTRACT(year from(v.orderDate))")
    List<?> sumTotalOfOrderByYears();

    @Query("select p from Order p where p.utilisateur.id =:user order by id Desc")
    List<Order> ListOrderByCustomerId(@Param("user") Long userId);

    @Query("select p from Order p where p.shippingAddress.id =:addLivraison order by id Desc")
    List<Order> ListOrderByAddressLivraisonId(@Param("addLivraison") Long addLivraison);

    @Query("select p from Order p where p.billingAddress.id =:addAchat order by id Desc")
    List<Order> ListOrderByAddressAchatId(@Param("addAchat") Long addAchat);

    @Query("select com from Order com where com.utilisateur.id =:userId")
    Page<Order> findOrderByUtilisateurPageables(@Param("userId") Long userId, Pageable pageable);

}
