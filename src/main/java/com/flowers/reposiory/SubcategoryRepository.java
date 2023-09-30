package com.flowers.reposiory;

import com.flowers.models.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    @Query("select p from Subcategory p where p.actif=1 and p.category.id =:cat")
    List<Subcategory> findSubcategoryByCategoryId(@Param("cat") Long catId);

    @Query("Select DISTINCT act from Subcategory act where act.actif=1 ORDER BY act.subCategoryName asc ")
    List<Subcategory> findAll();

}
