package com.flowers.services;

import com.flowers.models.Rating;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RatingService {

    Rating save(Rating rating);

    Rating saveRatingToArticle(Long id, Rating rating);

    Optional<Rating> findById(Long id);

    List<Rating> findAll();

    List<Rating> findByOrderByIdDesc();

    BigDecimal countNumberOfRating();

    BigDecimal countNumberOfRatingByProductId(String prodRef);

    List<Rating> findTop4ByOrderByCreatedDateDescByProductId(String prodRef);

    void delete(Long id);
}
