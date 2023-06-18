package com.flowers.reposiory;

import com.flowers.models.Product;
import com.flowers.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByOrderByIdDesc();

    @Query("select count(c) from Rating c where month(c.createdDate) = month(current_date)")
    BigDecimal countNumberOfRating();

    @Query("select count(c) from Rating c where c.actif=1 and c.product.reference =:prod")
    BigDecimal countNumberOfRatingnByProductId(@Param("prod") String prodRef);

    @Query("select n from Rating n where n.actif=1 and n.product.reference =:num")
    List<Rating> findTop4ByOrderByCreatedDateDesc(@Param("num") String prodRef);

    @Query("Select DISTINCT act from Rating act where act.actif=1 ORDER BY act.id desc ")
    List<Rating> findAll();

}
