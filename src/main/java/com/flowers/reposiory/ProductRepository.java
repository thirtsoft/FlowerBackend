package com.flowers.reposiory;

import com.flowers.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByReference(String reference);

    @Query("select p from Product p where p.subcategory.id =:subCat")
    List<Product> findProductBySubCategory(@Param("subCat") Long subCatId);

    @Query("select art from Product art where art.price like :price GROUP BY (art.price, art.id) ")
    List<Product> findProductGroupByPrice(@Param("price") double price);

    @Query("select art from Product art where art.isSelected = true")
    List<Product> findProductBySelected();

    @Query("select art from Product art where art.productName like :x")
    List<Product> findProductByKeyword(@Param("x") String mc);

    @Query("select p from Product p")
    Page<Product> findProductByPageable(Pageable pageable);

    @Query("select p from Product p where p.subcategory.id =:subCat")
    Page<Product> findProductBySubCategoryByPageable(@Param("subCat") Long subCat, Pageable pageable);

    @Query("select art from Product art where art.price like :price GROUP BY (art.price, art.id) ")
    Page<Product> findProductPageableGroupByPrice(@Param("price") double price, Pageable pageable);
}
