package com.flowers.services;

import com.flowers.models.Wishlist;

import java.util.List;
import java.util.Optional;

public interface WishlistService {

    Wishlist saveWhishlist(Wishlist whishlist);

    Optional<Wishlist> findWhishlistById(Long id);

    Wishlist updateWhishlist(Long whishlistId, Wishlist whishlist);

    List<Wishlist> findAllWishlists();

    List<Wishlist> findWishlistByOrderByIdDesc();

    void deleteWhishlist(Long whishlistId);


}
