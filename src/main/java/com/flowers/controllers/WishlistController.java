package com.flowers.controllers;

import com.flowers.controllers.api.WishlistApi;
import com.flowers.dtos.WishlistDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Wishlist;
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
        return null;
    }

    @Override
    public ResponseEntity<WishlistDto> updateWishlist(Long wishlistId, WishlistDto wishlistDto) {
        return null;
    }

    @Override
    public ResponseEntity<WishlistDto> getWishlistById(Long wishlistId) {
        return null;
    }

    @Override
    public ResponseEntity<List<WishlistDto>> getAllWishlists() {
        return null;
    }

    @Override
    public ResponseEntity<List<WishlistDto>> getAllWishlistsOrderByIdDesc() {
        return null;
    }

    @Override
    public void deleteWishlist(Long wishlistId) {
        wishlistService.deleteWhishlist(wishlistId);
    }
}
