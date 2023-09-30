package com.flowers.service;


import com.flowers.dtos.RatingDto;
import com.flowers.models.Product;
import com.flowers.models.Rating;
import com.flowers.models.Utilisateur;
import com.flowers.reposiory.ProductRepository;
import com.flowers.reposiory.RatingRepository;
import com.flowers.reposiory.UtilisateurRepository;
import com.flowers.services.Impl.RatingServiceImpl;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RatingServiceTest {

    @InjectMocks
    private RatingServiceImpl ratingService;

    @Mock
    private RatingRepository ratingRepository;

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void should_save_one_rating() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setName("Tairou");
        utilisateur.setUsername("thir");
        utilisateur.setMobile("779440310");
        utilisateurRepository.save(utilisateur);
        Product product = new Product();
        product.setReference("PROD1");
        product.setDesignation("Product1");
        productRepository.save(product);

        Rating rating = new Rating();
        rating.setId(1L);
        rating.setNbreEtoile(4);
        rating.setObservation("rat1");
        rating.setUtilisateur(utilisateur);
        rating.setProduct(product);

        when(ratingRepository.save(any(Rating.class))).thenReturn(rating);

        RatingDto ratingDto = ratingService.save(RatingDto.fromEntityToDto(new Rating()));

        Rating ratingResult = RatingDto.fromDtoToEntity(ratingDto);

        assertThat(ratingResult).usingRecursiveComparison().isEqualTo(rating);
        verify(ratingRepository, times(1)).save(any(Rating.class));
        verifyNoMoreInteractions(ratingRepository);
    }

    @Test
    public void should_save_one_rating_to_product() {
        Product product = new Product();
        product.setReference("PROD2");
        product.setDesignation("Product2");
        productRepository.save(product);

        Rating rating = new Rating();
        rating.setId(2L);
        rating.setNbreEtoile(5);
        rating.setObservation("rat2");
        rating.setProduct(product);

        when(ratingRepository.save(any(Rating.class))).thenReturn(rating);

        RatingDto ratingDto = ratingService.save(RatingDto.fromEntityToDto(new Rating()));

        Rating ratingResult = RatingDto.fromDtoToEntity(ratingDto);

        assertThat(ratingResult).usingRecursiveComparison().isEqualTo(rating);
        verify(ratingRepository, times(1)).save(any(Rating.class));
        verifyNoMoreInteractions(ratingRepository);
    }


    @Test
    public void should_find_and_return_all_ratings() {
        Rating rating = new Rating();
        rating.setId(5L);
        rating.setNbreEtoile(5);
        rating.setObservation("rat5");

        when(ratingRepository.findAll()).thenReturn(singletonList(rating));

        List<RatingDto> ratingList = ratingService.findAllActiveRatings();

        assertThat(ratingList).isNotNull();
        assertThat(ratingList).hasSize(1);
        verify(ratingRepository, times(1)).findAll();
        verifyNoMoreInteractions(ratingRepository);
    }

    @Test
    public void should_find_and_return_all_ratings_by_Id_desc() {
        Rating rating = new Rating();
        rating.setId(6L);
        rating.setNbreEtoile(3);
        rating.setObservation("rat6");

        when(ratingRepository.findAll()).thenReturn(singletonList(rating));

        List<RatingDto> ratingList = ratingService.findAllActiveRatings();

        assertThat(ratingList).isNotNull();
        assertThat(ratingList).hasSize(1);
        verify(ratingRepository, times(1)).findAll();
        verifyNoMoreInteractions(ratingRepository);
    }

    @Test
    public void should_find_and_return_top4_ratings_by_product_Id() {
        String ref = "prod01";
        when(ratingRepository.findTop4ByOrderByCreatedDateDesc(ref)).thenReturn(singletonList(any()));

        List<RatingDto> ratingList = ratingService.findTop4ByOrderByCreatedDateDescByProductId(ref);

        assertThat(ratingList).isNotNull();
        assertThat(ratingList).hasSize(1);
        assertThat(ratingList.size()).isGreaterThanOrEqualTo(0);
        verify(ratingRepository, times(1)).findTop4ByOrderByCreatedDateDesc(ref);
        verifyNoMoreInteractions(ratingRepository);
    }

    @Test
    public void should_delete_one_rating() {
        doNothing().when(ratingRepository).deleteById(anyLong());

        ratingService.deleteRating(anyLong());
        verify(ratingRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(ratingRepository);
    }


}
