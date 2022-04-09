package com.flowers.controllers;

import com.flowers.controllers.api.WishlistApi;
import com.flowers.dtos.WishlistDto;
import com.flowers.services.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WishlistController implements WishlistApi {

    private final WishlistService wishlistService;


    @Override
    public ResponseEntity<WishlistDto> saveWishlist(WishlistDto wishlistDto) {
        WishlistDto wishlistDtoResult = wishlistService.saveWhishlist(wishlistDto);
        return new ResponseEntity<>(wishlistDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WishlistDto> updateWishlist(Long wishlistId, WishlistDto wishlistDto) {
        wishlistDto.setId(wishlistId);
        WishlistDto wishlistDtoResult = wishlistService.saveWhishlist(wishlistDto);
        return new ResponseEntity<>(wishlistDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WishlistDto> getWishlistById(Long wishlistId) {
        WishlistDto wishlistDtoResult = wishlistService.findWhishlistById(wishlistId);
        return new ResponseEntity<>(wishlistDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<WishlistDto>> getAllWishlists() {
        List<WishlistDto> wishlistDtoList = wishlistService.findAllWishlists();
        return new ResponseEntity<>(wishlistDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<WishlistDto>> getAllWishlistsOrderByIdDesc() {
        List<WishlistDto> wishlistDtoList = wishlistService.findWishlistByOrderByIdDesc();
        return new ResponseEntity<>(wishlistDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteWishlist(Long wishlistId) {
        wishlistService.deleteWhishlist(wishlistId);
    }
}
