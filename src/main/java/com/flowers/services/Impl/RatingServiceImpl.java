package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Category;
import com.flowers.models.Product;
import com.flowers.models.Rating;
import com.flowers.reposiory.RatingRepository;
import com.flowers.services.ProductService;
import com.flowers.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {


    private final RatingRepository ratingRepository;

    private final ProductService productService;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository,
                             ProductService productService) {
        this.ratingRepository = ratingRepository;
        this.productService = productService;
    }


    @Override
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating saveRatingToArticle(Long id, Rating rating) {
        Optional<Product> productOptional = productService.findById(id);
        Product productResult = productOptional.get();
        rating.setProduct(productResult);
        return ratingRepository.save(rating);
    }

    @Override
    public Optional<Rating>  findById(Long id) {
        if (!ratingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Rating that id is" + id + "is not found");
        }
        return ratingRepository.findById(id);
    }

    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> findByOrderByIdDesc() {
        return ratingRepository.findByOrderByIdDesc();
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
    public List<Rating> findTop4ByOrderByCreatedDateDescByProductId(String prodRef) {
        return ratingRepository.findTop4ByOrderByCreatedDateDesc(prodRef);
    }

    @Override
    public void delete(Long id) {
        if (!ratingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Rating that id is" + id + "is not found");
        }
        ratingRepository.deleteById(id);
    }
}
