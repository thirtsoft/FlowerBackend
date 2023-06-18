package com.flowers.reposiory;

import com.flowers.models.Category;
import com.flowers.models.Commande;
import com.flowers.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByOrderByIdDesc();

    @Query("Select DISTINCT act from Country act where act.actif=1 ORDER BY act.name")
    List<Country> findAll();

}
