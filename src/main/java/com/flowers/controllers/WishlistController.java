package com.flowers.controllers;

import com.flowers.controllers.api.WishlistApi;
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
    public ResponseEntity<Wishlist> saveWishlist(Wishlist wishlist) {
        return ResponseEntity.ok(wishlistService.saveWhishlist(wishlist));
    }

    @Override
    public ResponseEntity<Wishlist> updateWishlist(Long wishlistId, Wishlist wishlist) {
        wishlist.setId(wishlistId);
        return ResponseEntity.ok(wishlistService.saveWhishlist(wishlist));
    }

    @Override
    public ResponseEntity<Wishlist> getWishlistById(Long wishlistId) throws ResourceNotFoundException {
        Wishlist wishlist = wishlistService.findWhishlistById(wishlistId)
                .orElseThrow(() -> new ResourceNotFoundException("Wishlist not found"));
        return ResponseEntity.ok().body(wishlist);
    }

    @Override
    public ResponseEntity<List<Wishlist>> getAllWishlists() {
        List<Wishlist> wishlistList = wishlistService.findAllWishlists();
        return new ResponseEntity<>(wishlistList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Wishlist>> getAllWishlistsOrderByIdDesc() {
        List<Wishlist> wishlistList = wishlistService.findWishlistByOrderByIdDesc();
        return new ResponseEntity<>(wishlistList, HttpStatus.OK);
    }

    @Override
    public void deleteWishlist(Long wishlistId) {
        wishlistService.deleteWhishlist(wishlistId);
    }
}
