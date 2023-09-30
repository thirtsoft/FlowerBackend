package com.flowers.repository;

import com.flowers.models.Product;
import com.flowers.models.Rating;
import com.flowers.models.Utilisateur;
import com.flowers.reposiory.ProductRepository;
import com.flowers.reposiory.RatingRepository;
import com.flowers.reposiory.UtilisateurRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RatingRepositoryTest {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_rating_Test() {
        Product product = new Product();
        product.setReference("PROD01");
        product.setDesignation("Product01");
        product.setPrice(5500);
        product.setQuantity(10);
        productRepository.save(product);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setName("Tairou");
        utilisateur.setUsername("thir");
        utilisateurRepository.save(utilisateur);
        Rating rating = new Rating();
        rating.setNbreEtoile(4);
        rating.setObservation("bien");
        rating.setProduct(product);
        rating.setUtilisateur(utilisateur);
        ratingRepository.save(rating);

        assertThat(rating.getId()).isGreaterThan(0);
        assertThat(rating.getNbreEtoile()).isNotNull();
        assertThat(rating.getProduct()).isEqualTo(product);
        assertThat(rating.getObservation()).isEqualTo("bien");
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void save_rating_to_product_Test() {
        Product product = new Product();
        product.setReference("PROD0001");
        product.setDesignation("Product01");
        product.setPrice(5500);
        product.setQuantity(10);
        productRepository.save(product);
        Product productResult = productRepository.findById(product.getId()).get();
        Rating rating = new Rating();
        rating.setNbreEtoile(4);
        rating.setObservation("bien");
        rating.setProduct(productResult);
        ratingRepository.save(rating);

        assertThat(rating.getId()).isGreaterThan(0);
        assertThat(rating.getNbreEtoile()).isNotNull();
        assertThat(rating.getProduct()).isEqualTo(product);
        assertThat(rating.getObservation()).isEqualTo("bien");
    }


    @Test
    @Order(3)
    public void get_and_return_on_rating_by_Id_Test() {
        Product product = new Product();
        product.setReference("ProdByID");
        product.setDesignation("Product01");
        product.setPrice(5500);
        product.setQuantity(10);
        productRepository.save(product);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setName("Tairou");
        utilisateur.setUsername("thirID");
        utilisateurRepository.save(utilisateur);
        Rating rating = new Rating();
        rating.setNbreEtoile(4);
        rating.setObservation("bien");
        rating.setProduct(product);
        rating.setUtilisateur(utilisateur);
        ratingRepository.save(rating);

        Rating optionalRating = ratingRepository.findById(rating.getId()).get();

        assertThat(optionalRating.getId()).isEqualTo(rating.getId());
        assertThat(optionalRating.getObservation()).isEqualTo(rating.getObservation());
    }


    @Test
    @Order(4)
    @Rollback(value = false)
    public void update_rating_by_id_Test() {
        Optional<Rating> optionalRating = ratingRepository.findById(1L);
        if (optionalRating.isPresent()) {
            Rating rating = optionalRating.get();
            rating.setNbreEtoile(5);

            Rating ratingUpdated = ratingRepository.save(rating);
            assertThat(ratingUpdated.getId()).isEqualTo(rating.getId());
            assertThat(ratingUpdated.getNbreEtoile()).isEqualTo(5);
        }
    }

    @Test
    @Order(5)
    public void should_and_return_all_ratings_Test() {
        Rating rating = new Rating();
        rating.setNbreEtoile(4);
        rating.setObservation("bien");
        ratingRepository.save(rating);

        List<Rating> ratingList = ratingRepository.findAll();

        assertThat(ratingList.size()).isNotNull();
        assertThat(ratingList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(6)
    public void should_and_return_all_ratings_by_IdDesc_Test() {
        Rating rating = new Rating();
        rating.setNbreEtoile(4);
        rating.setObservation("bien");
        ratingRepository.save(rating);

        List<Rating> ratingList = ratingRepository.findAll();

        assertThat(ratingList.size()).isNotNull();
        assertThat(ratingList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(7)
    public void should_and_return_top4_ratings_by_product_id_order_desc_Test() {
        String refProd = "Prod001";
        List<Rating> ratingList = ratingRepository.findTop4ByOrderByCreatedDateDesc(refProd);

        assertThat(ratingList.size()).isNotNull();
        assertThat(ratingList.size()).isGreaterThanOrEqualTo(0);
    }


    @Test
    @Order(8)
    public void get_number_Of_rating_Test() {
        BigDecimal number = ratingRepository.countNumberOfRating();
        BigDecimal val = BigDecimal.valueOf(200);
        assertThat(number).isLessThan(val);
    }


    @Test
    @Order(9)
    public void get_number_Of_rating_by_product_id_Test() {
        String prodRef = "PROD001";
        BigDecimal number = ratingRepository.countNumberOfRatingnByProductId(prodRef);
        BigDecimal val = BigDecimal.valueOf(200);
        assertThat(number).isLessThan(val);
    }

    @Test
    @Order(10)
    @Rollback(value = false)
    public void delete_rating_by_id_Test() {
        Optional<Rating> optionalRating = ratingRepository.findById(1L);
        if (optionalRating.isPresent()) {
            ratingRepository.delete(optionalRating.get());
        }
        Rating rating = null;
        Optional<Rating> optionalRating01 = ratingRepository.findById(1L);
        if (optionalRating01.isPresent()) {
            rating = optionalRating01.get();
        }
        assertThat(rating).isNull();
    }

}
