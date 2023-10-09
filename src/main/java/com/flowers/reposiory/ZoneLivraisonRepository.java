package com.flowers.reposiory;

import com.flowers.models.ZoneLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneLivraisonRepository extends JpaRepository<ZoneLivraison, Long> {

    @Query("Select DISTINCT act from ZoneLivraison act where act.actif=1 ORDER BY act.libelle asc ")
    List<ZoneLivraison> findAll();
}
