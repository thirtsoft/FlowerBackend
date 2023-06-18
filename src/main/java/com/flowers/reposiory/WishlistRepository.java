package com.flowers.reposiory;

import com.flowers.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    List<Wishlist> findByOrderByIdDesc();

    @Query("Select DISTINCT act from Wishlist act where act.actif=1 ORDER BY act.id desc")
    List<Wishlist> findAll();

}
