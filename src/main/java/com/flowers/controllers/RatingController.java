package com.flowers.controllers;

import com.flowers.controllers.api.RatingApi;
import com.flowers.dtos.RatingDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Product;
import com.flowers.models.Rating;
import com.flowers.models.Utilisateur;
import com.flowers.services.ProductService;
import com.flowers.services.RatingService;
import com.flowers.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class RatingController implements RatingApi {

    private final RatingService ratingService;

    private final ProductService productService;

    private final UtilisateurService utilisateurService;

    @Autowired
    public RatingController(RatingService ratingService,
                            ProductService productService,
                            UtilisateurService utilisateurService) {
        this.ratingService = ratingService;
        this.productService = productService;
        this.utilisateurService = utilisateurService;
    }

    @Override
    public ResponseEntity<RatingDto> saveRating(RatingDto ratingDto) {
        return null;
    }

    @Override
    public ResponseEntity<RatingDto> saveRatingToArticle(Long id, RatingDto ratingDto) {
        return null;
    }

    @Override
    public ResponseEntity<RatingDto> saveRating(RatingDto ratingDto, String reference, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<RatingDto> getRatingById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<RatingDto>> getAllRatings() {
        return null;
    }

    @Override
    public ResponseEntity<List<RatingDto>> getAllRatingsOrderByIdDesc() {
        return null;
    }

    @Override
    public BigDecimal countNumberOfRating() {
        return null;
    }

    @Override
    public BigDecimal countNumberOfRatingByProductId(String prodRef) {
        return null;
    }

    @Override
    public ResponseEntity<List<RatingDto>> getTop4ByOrderByCreatedDateDescByProductId(String prodRef) {
        return null;
    }

    @Override
    public void delete(Long id) {
        ratingService.delete(id);
    }
}
