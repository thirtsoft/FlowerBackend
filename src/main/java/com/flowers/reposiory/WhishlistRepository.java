package com.flowers.reposiory;

import com.flowers.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhishlistRepository extends JpaRepository<Wishlist, Long> {
}
