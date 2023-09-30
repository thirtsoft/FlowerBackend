package com.flowers.services.Impl;

import com.flowers.dtos.ProductDto;
import com.flowers.dtos.RatingDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Rating;
import com.flowers.reposiory.RatingRepository;
import com.flowers.services.ProductService;
import com.flowers.services.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    private final ProductService productService;

    public RatingServiceImpl(RatingRepository ratingRepository,
                             ProductService productService) {
        this.ratingRepository = ratingRepository;
        this.productService = productService;
    }

    @Override
    public RatingDto save(RatingDto ratingDto) {
        ratingDto.setActif(true);
        return RatingDto.fromEntityToDto(
                ratingRepository.save(
                        RatingDto.fromDtoToEntity(ratingDto)
                )
        );
    }

    @Override
    public RatingDto saveRatingToArticle(Long id, RatingDto ratingDto) {
        ProductDto productDTOOptional = productService.findById(id);
        ratingDto.setProductDto(productDTOOptional);
        ratingDto.setActif(true);
        return RatingDto.fromEntityToDto(
                ratingRepository.save(
                        RatingDto.fromDtoToEntity(ratingDto)
                )
        );
    }

    @Override
    public BigDecimal countNumberOfRating() {
        return ratingRepository.countNumberOfRating();
    }

    @Override
    public BigDecimal countNumberOfRatingByProductId(String prodRef) {
        return ratingRepository.countNumberOfRatingnByProductId(prodRef);
    }

    @Override
    public List<RatingDto> findTop4ByOrderByCreatedDateDescByProductId(String prodRef) {
        return ratingRepository.findTop4ByOrderByCreatedDateDesc(prodRef).stream()
                .map(RatingDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RatingDto> findAllActiveRatings() {
        return ratingRepository.findAll().stream()
                .map(RatingDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRating(Long ratId) {
        if (ratId == null) {
            log.error("Rating not found");
            return;
        }
        Rating rating = ratingRepository.findById(ratId).get();
        rating.setActif(false);
        ratingRepository.save(rating);
    }
}
