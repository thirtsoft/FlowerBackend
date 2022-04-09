package com.flowers.reposiory;

import com.flowers.models.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    @Query("select p from Subcategory p where p.category.id =:cat")
    List<Subcategory> findSubcategoryByCategoryId(@Param("cat") Long catId);

    List<Subcategory> findByOrderByIdDesc();

}
