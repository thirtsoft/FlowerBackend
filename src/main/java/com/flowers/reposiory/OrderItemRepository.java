package com.flowers.reposiory;

import com.flowers.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query("select (p.productName), count(p) from OrderItem p group by (p.productId)")
    List<OrderItem> findArticlesGroupByProductId();

    List<OrderItem> findByOrderByIdDesc();

    @Query("select p from OrderItem p where p.order.id =:num")
    List<OrderItem> ListOrderItemByOrderId(@Param("num") Long comId);

    List<OrderItem> findTop200ByOrderByIdDesc();

}
