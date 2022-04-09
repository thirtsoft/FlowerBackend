package com.flowers.reposiory;

import com.flowers.models.Category;
import com.flowers.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByOrderByIdDesc();

}
