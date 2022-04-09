package com.flowers.dtos;

import com.flowers.models.Rating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {

    private Long id;

    private float nbreEtoile;

    private String observation;

    private Date createdDate;

    private ProductDto productDto;

    private UtilisateurDto utilisateurDto;

    public static RatingDto fromEntityToDto(Rating rating) {
        if (rating == null) {
            return null;
        }

        return RatingDto.builder()
                .id(rating.getId())
                .nbreEtoile(rating.getNbreEtoile())
                .observation(rating.getObservation())
                .createdDate(rating.getCreatedDate())
                .productDto(ProductDto.fromEntityToDto(rating.getProduct()))
                .utilisateurDto(UtilisateurDto.fromEntityToDto(rating.getUtilisateur()))
                .build();
    }

    public static Rating fromDtoToEntity(RatingDto ratingDto) {
        if (ratingDto == null) {
            return null;
        }

        Rating rating = new Rating();
        rating.setId(ratingDto.getId());
        rating.setNbreEtoile(ratingDto.getNbreEtoile());
        rating.setObservation(ratingDto.getObservation());
        rating.setCreatedDate(ratingDto.getCreatedDate());
        rating.setProduct(ProductDto.fromDtoToEntity(ratingDto.getProductDto()));
        rating.setUtilisateur(UtilisateurDto.fromDtoToEntity(ratingDto.getUtilisateurDto()));

        return rating;
    }


}
