package com.flowers.services;

import com.flowers.dtos.UtilisateurDto;
import com.flowers.dtos.WishlistDto;

import java.util.List;

public interface WishlistService {

    WishlistDto saveWhishlist(WishlistDto wishlistDto);

    WishlistDto findWhishlistById(Long id);

    WishlistDto updateWhishlist(Long whishlistId, WishlistDto wishlistDto);

    List<WishlistDto> findAllWishlists();

    List<WishlistDto> findWishlistByOrderByIdDesc();

    void deleteWhishlist(Long whishlistId);

    List<WishlistDto> findAllActiveWishlists();

    void deleteWishlist(Long wishId);


}
