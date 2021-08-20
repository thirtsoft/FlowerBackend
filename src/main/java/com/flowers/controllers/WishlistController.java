package com.flowers.controllers;

import com.flowers.controllers.api.WishlistApi;
import com.flowers.models.Wishlist;
import com.flowers.services.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WishlistController implements WishlistApi {

    private final WishlistService wishlistService;
    
    @Override
    public ResponseEntity<Wishlist> save(Wishlist wishlist) {
        return null;
    }

    @Override
    public ResponseEntity<Wishlist> update(Long id, Wishlist wishlist) {
        return null;
    }

    @Override
    public ResponseEntity<Wishlist> findById(Long id) {
        return null;
    }

    @Override
    public List<Wishlist> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
