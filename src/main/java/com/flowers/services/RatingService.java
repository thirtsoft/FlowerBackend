package com.flowers.services;

import com.flowers.dtos.RatingDto;

import java.math.BigDecimal;
import java.util.List;

public interface RatingService {

    RatingDto save(RatingDto ratingDto);

    RatingDto saveRatingToArticle(Long id, RatingDto ratingDto);

    BigDecimal countNumberOfRating();

    BigDecimal countNumberOfRatingByProductId(String prodRef);

    List<RatingDto> findTop4ByOrderByCreatedDateDescByProductId(String prodRef);

    List<RatingDto> findAllActiveRatings();

    void deleteRating(Long ratId);
}
