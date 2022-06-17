package com.flowers.reposiory;

import com.flowers.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

  //  @Query("select count(c) from Utilisateur c where c.Role.name =='ROLE_USER'")
  //  BigDecimal countNumberOfNewRegister();

    List<Utilisateur> findByOrderByIdDesc();
}
