package com.flowers.services;

import com.flowers.dtos.ProductDto;
import com.flowers.dtos.RatingDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RatingService {

    RatingDto save(RatingDto ratingDto);

    RatingDto saveRatingToArticle(Long id, RatingDto ratingDto);

    RatingDto findById(Long id);

    List<RatingDto> findAll();

    List<RatingDto> findByOrderByIdDesc();

    BigDecimal countNumberOfRating();

    BigDecimal countNumberOfRatingByProductId(String prodRef);

    List<RatingDto> findTop4ByOrderByCreatedDateDescByProductId(String prodRef);

    void delete(Long id);

    List<RatingDto> findAllActiveRatings();

    void deleteRating(Long ratId);
}
