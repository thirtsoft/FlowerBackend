package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
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
    public Wishlist saveWhishlist(Wishlist whishlist) {
        return wishlistRepository.save(whishlist);
    }

    @Override
    public Optional<Wishlist> findWhishlistById(Long id) {
        if (!wishlistRepository.existsById(id)) {
            throw new ResourceNotFoundException("Wishlist that id is " + id + "not found");
        }
        return wishlistRepository.findById(id);
    }

    @Override
    public Wishlist updateWhishlist(Long whishlistId, Wishlist whishlist) {
        if (!wishlistRepository.existsById(whishlistId)) {
            throw new ResourceNotFoundException("Wishlist that id is" + whishlistId + "is not found");
        }
        Optional<Wishlist> optionalWishlist = wishlistRepository.findById(whishlistId);

        if (!optionalWishlist.isPresent()) {
            throw new ResourceNotFoundException("Wishlist not found");
        }

        Wishlist wishlistResult = optionalWishlist.get();
        wishlistResult.setReference(whishlist.getReference());
        wishlistResult.setNombreEtoile(whishlist.getNombreEtoile());
        wishlistResult.setObservation(whishlist.getObservation());
        wishlistResult.setDescription(whishlist.getDescription());
        wishlistResult.setUtilisateur(whishlist.getUtilisateur());
        wishlistResult.setProduct(whishlist.getProduct());

        return wishlistRepository.save(wishlistResult);
    }

    @Override
    public List<Wishlist> findAllWishlists() {
        return wishlistRepository.findAll();
    }

    @Override
    public List<Wishlist> findWishlistByOrderByIdDesc() {
        return wishlistRepository.findByOrderByIdDesc();
    }

    @Override
    public void deleteWhishlist(Long whishlistId) {
        if (!wishlistRepository.existsById(whishlistId)) {
            throw new ResourceNotFoundException("Wishlist that id is" + whishlistId + "is not found");
        }
        wishlistRepository.deleteById(whishlistId);

    }


}
