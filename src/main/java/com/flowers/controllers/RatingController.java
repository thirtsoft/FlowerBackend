package com.flowers.controllers;

import com.flowers.controllers.api.RatingApi;
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
    public ResponseEntity<Rating> save(Rating rating) {
        return ResponseEntity.ok(ratingService.save(rating));
    }

    @Override
    public ResponseEntity<Rating> saveRatingToArticle(Long id, Rating rating) {
        return ResponseEntity.ok(ratingService.saveRatingToArticle(id, rating));
    }

    @Override
    public ResponseEntity<Rating> saveRating(Rating rating, String reference, Long id) {

        Optional<Product> optionalProduct = productService.findByReference(reference);

        Optional<Utilisateur> optionalUtilisateur = utilisateurService.findUtilisateurById(id);

        Product productResult = optionalProduct.get();

        Utilisateur utilisateur = optionalUtilisateur.get();

        rating.setProduct(productResult);
        rating.setUtilisateur(utilisateur);

        rating.setCreatedDate(new Date());

        Rating ratingResult = ratingService.save(rating);


        return new ResponseEntity<>(ratingResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Rating> getRatingById(Long id) throws ResourceNotFoundException {
        Rating rating = ratingService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found"));
        return ResponseEntity.ok().body(rating);
    }

    @Override
    public ResponseEntity<List<Rating>> findAll() {
        List<Rating> ratingList = ratingService.findAll();

        return new ResponseEntity(ratingList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Rating>> getAllratingsOrderByIdDesc() {
        List<Rating> ratingList = ratingService.findByOrderByIdDesc();
        return new ResponseEntity(ratingList, HttpStatus.OK);
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
    public ResponseEntity<List<Rating>> getTop4ByOrderByCreatedDateDescByProductId(String prodRef) {
        List<Rating> ratingList = ratingService.findTop4ByOrderByCreatedDateDescByProductId(prodRef);
        return new ResponseEntity(ratingList, HttpStatus.OK);
    }

    @Override
    public void delete(Long id) {
        ratingService.delete(id);
    }
}
