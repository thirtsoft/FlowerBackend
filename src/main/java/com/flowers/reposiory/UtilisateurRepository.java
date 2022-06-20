package com.flowers.reposiory;

import com.flowers.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Optional<Utilisateur> findByUsername(String username);

    Optional<Utilisateur> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query("select count(u) from Utilisateur u where month(u.createdDate) = month(current_date)")
    BigDecimal countNumberOfRegisterInMonth();

    @Query("select EXTRACT(month from(c.createdDate)), count(c) from Utilisateur c group by EXTRACT(month from(c.createdDate))")
    List<?> countNumberOfRegisterUserByMonth();

    List<Utilisateur> findByOrderByIdDesc();
}
