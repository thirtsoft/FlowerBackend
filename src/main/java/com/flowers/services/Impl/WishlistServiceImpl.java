package com.flowers.services.Impl;

import com.flowers.dtos.WishlistDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Wishlist;
import com.flowers.reposiory.WishlistRepository;
import com.flowers.services.WishlistService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;

    @Override
    public WishlistDto saveWhishlist(WishlistDto wishlistDto) {
        return WishlistDto.fromEntityToDto(
                wishlistRepository.save(
                        WishlistDto.fromDtoToEntity(wishlistDto)
                )
        );
    }

    @Override
    public WishlistDto updateWhishlist(Long whishlistId, WishlistDto wishlistDto) {
        if (!wishlistRepository.existsById(whishlistId)) {
            throw new ResourceNotFoundException("Wishlist not found");
        }

        Optional<Wishlist> optionalWishlist = wishlistRepository.findById(whishlistId);

        if (!optionalWishlist.isPresent()) {
            throw new ResourceNotFoundException("Wishlist not found");
        }

        WishlistDto wishlistDtoResult = WishlistDto.fromEntityToDto(optionalWishlist.get());

        wishlistDtoResult.setReference(wishlistDto.getReference());
        wishlistDtoResult.setNbreEtoile(wishlistDto.getNbreEtoile());
        wishlistDtoResult.setObservation(wishlistDto.getObservation());
        wishlistDtoResult.setDescription(wishlistDto.getDescription());
        wishlistDtoResult.setProductDto(wishlistDto.getProductDto());
        wishlistDtoResult.setUtilisateurDto(wishlistDto.getUtilisateurDto());

        return WishlistDto.fromEntityToDto(
                wishlistRepository.save(
                        WishlistDto.fromDtoToEntity(wishlistDtoResult)
                )
        );
    }

    @Override
    public WishlistDto findWhishlistById(Long id) {
        if (id == null) {
            log.error("Wishlist Id is null");
            return null;
        }

        Optional<Wishlist> optionalWishlist = wishlistRepository.findById(id);

        return Optional.of(WishlistDto.fromEntityToDto(optionalWishlist.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun Wishlist avec l'Id = " + id + "n'a été trouvé")
        );
    }

    @Override
    public List<WishlistDto> findAllWishlists() {
        return wishlistRepository.findAll().stream()
                .map(WishlistDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<WishlistDto> findWishlistByOrderByIdDesc() {
        return wishlistRepository.findByOrderByIdDesc().stream()
                .map(WishlistDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteWhishlist(Long whishlistId) {
        if (whishlistId == null) {
            log.error("Wishlist not found");
            return;
        }
        wishlistRepository.deleteById(whishlistId);
    }
}
