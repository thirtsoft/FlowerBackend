package com.flowers.reposiory;

import com.flowers.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("Select DISTINCT act from Category act where act.actif=1 ORDER BY act.categoryName asc ")
    List<Category> findAll();

}
