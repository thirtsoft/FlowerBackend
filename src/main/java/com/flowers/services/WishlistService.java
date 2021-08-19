package com.flowers.services;

import com.flowers.models.Wishlist;

import java.util.List;
import java.util.Optional;

public interface WishlistService {

    List<Wishlist> findAllWishlists();

    Wishlist saveWhishlist(Wishlist whishlist);

    Optional<Wishlist> findWhishlistById(Long id);

    Wishlist updateWhishlist(Long catId, Wishlist whishlist);

    void deleteWhishlist(Long catId);

    Wishlist findByCode(String code);

    Wishlist findByDesignation(String designation);

    List<Wishlist> ListWhishlistByCode(String designation);

    List<Wishlist> ListWhishlistByDesignation(String designation);


}
