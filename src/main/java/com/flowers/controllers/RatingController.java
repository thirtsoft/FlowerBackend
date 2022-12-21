package com.flowers.controllers;

import com.flowers.controllers.api.RatingApi;
import com.flowers.dtos.ProductDto;
import com.flowers.dtos.RatingDto;
import com.flowers.dtos.UtilisateurDto;
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

@CrossOrigin(origins = {"https://fleurpourtous.com", "https://portail.fleurpourtous.com"})
//@CrossOrigin
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
        RatingDto ratingDtoResult = ratingService.save(ratingDto);
        return new ResponseEntity<>(ratingDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RatingDto> saveRatingToArticle(Long id, RatingDto ratingDto) {
        RatingDto ratingDtoResult = ratingService.saveRatingToArticle(id, ratingDto);
        return new ResponseEntity<>(ratingDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RatingDto> saveRating(RatingDto ratingDto, String reference, Long id) {

    //    Product product = Optional.of(ProductDto.fromDtoToEntity(productService.findByReference(reference))).get();

        ProductDto productDto = productService.findByReference(reference);

    //    Utilisateur utilisateur = Optional.of(UtilisateurDto.fromDtoToEntity(utilisateurService.findUtilisateurById(id))).get();

        UtilisateurDto utilisateurDto = utilisateurService.findUtilisateurById(id);

        ratingDto.setProductDto(productDto);
        ratingDto.setUtilisateurDto(utilisateurDto);
        ratingDto.setCreatedDate(new Date());

        RatingDto ratingDtoResult = ratingService.save(ratingDto);

        return new ResponseEntity<>(ratingDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RatingDto> getRatingById(Long id) {
        RatingDto ratingDtoResult = ratingService.findById(id);
        return new ResponseEntity<>(ratingDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RatingDto>> getAllRatings() {
        List<RatingDto> ratingDtoList = ratingService.findAll();
        return new ResponseEntity<>(ratingDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RatingDto>> getAllRatingsOrderByIdDesc() {
        List<RatingDto> ratingDtoList = ratingService.findByOrderByIdDesc();
        return new ResponseEntity<>(ratingDtoList, HttpStatus.OK);
    }

    @Override
    public BigDecimal countNumberOfRating() {
        return ratingService.countNumberOfRating();
    }

    @Override
    public BigDecimal countNumberOfRatingByProductId(String prodRef) {
        return ratingService.countNumberOfRatingByProductId(prodRef);
    }

    @Override
    public ResponseEntity<List<RatingDto>> getTop4ByOrderByCreatedDateDescByProductId(String prodRef) {
        List<RatingDto> ratingDtoList = ratingService.findTop4ByOrderByCreatedDateDescByProductId(prodRef);
        return new ResponseEntity<>(ratingDtoList, HttpStatus.OK);
    }

    @Override
    public void delete(Long id) {
        ratingService.delete(id);
    }
}
