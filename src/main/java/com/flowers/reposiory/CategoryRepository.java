package com.flowers.reposiory;

import com.flowers.models.Address;
import com.flowers.models.Blog;
import com.flowers.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByOrderByIdDesc();

    @Query("Select DISTINCT act from Category act where act.actif=1 ORDER BY act.categoryName")
    List<Category> findAll();

}
