package com.flowers.controllers.api;

import com.flowers.models.Wishlist;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface WishlistApi {

    @PostMapping(value = APP_ROOT + "/wishlists/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Wishlist> save(@RequestBody Wishlist wishlist);

    @PutMapping(value = APP_ROOT + "/wishlists/update/{idWishlist}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Wishlist> update(@PathVariable("idWishlist") Long id, @RequestBody Wishlist wishlist);

    @GetMapping(value = APP_ROOT + "/wishlists/{idWishlist}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Wishlist> findById(@PathVariable("idWishlist") Long id);

    @GetMapping(value = APP_ROOT + "/wishlists/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Wishlist> findAll();

    @DeleteMapping(value = APP_ROOT + "/wishlists/delete/{idWishlist}")
    void delete(@PathVariable("idWishlist") Long id);
}
