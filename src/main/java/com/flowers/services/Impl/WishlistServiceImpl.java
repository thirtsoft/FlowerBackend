package com.flowers.services.Impl;

import com.flowers.models.Wishlist;
import com.flowers.reposiory.WishlistRepository;
import com.flowers.services.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;

    @Override
    public List<Wishlist> findAllWishlists() {
        return null;
    }

    @Override
    public Wishlist saveWhishlist(Wishlist whishlist) {
        return null;
    }

    @Override
    public Optional<Wishlist> findWhishlistById(Long id) {
        return Optional.empty();
    }

    @Override
    public Wishlist updateWhishlist(Long catId, Wishlist whishlist) {
        return null;
    }

    @Override
    public void deleteWhishlist(Long catId) {

    }

    @Override
    public Wishlist findByCode(String code) {
        return null;
    }

    @Override
    public Wishlist findByDesignation(String designation) {
        return null;
    }

    @Override
    public List<Wishlist> ListWhishlistByCode(String designation) {
        return null;
    }

    @Override
    public List<Wishlist> ListWhishlistByDesignation(String designation) {
        return null;
    }
}
