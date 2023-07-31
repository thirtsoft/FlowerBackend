package com.flowers.reposiory;

import com.flowers.models.Newsletter;
import com.flowers.models.Product;
import com.flowers.models.Rating;
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

    @Query("select p from Product p where p.actif=1 and p.subcategory.id =:subCat")
    List<Product> findProductBySubcategory(@Param("subCat") Long subCatId);

    @Query("select p from Product p where p.actif=1 and p.subcategory.subCategoryName =:subCatName")
    List<Product> findProductBySubcategoryName(@Param("subCatName") String subCatName);

    @Query("select art from Product art where art.actif=1 and art.price like :price GROUP BY (art.price, art.id) ")
    List<Product> findProductGroupByPrice(@Param("price") double price);

    @Query("select art from Product art where art.actif=1 and art.isSelected = true")
    List<Product> findProductBySelected();

    @Query("select art from Product art where art.actif=1 and art.isPromo = true")
    List<Product> findProductByPromo();

    @Query("Select DISTINCT act from Product act where act.actif=1 ORDER BY act.createdDate desc")
    List<Product> findTop24ByOrderByCreatedDateDesc();

    List<Product> findTop8ByOrderByIdDesc();

    List<Product> findTop3ByOrderByIdDesc();

    List<Product> findTop4ByOrderByIdDesc();

    List<Product> findByOrderByIdDesc();

    Page<Product> findBySubcategory(Long id, Pageable pageable);

    // Like  key%  %key  %key%
    Page<Product> findByDesignationContaining(String designation, Pageable pageable);

    @Query("select count(id) from Product where subcategory.id = ?1")
    long getOrderLengthBySubcategoryId(long id);

    @Query("select count(id) from Product where designation LIKE %?1%")
    long getOrderSizeByKey(String key);

    @Query("select p from Product p where p.actif=1 and p.price between :min and :max")
    List<Product> findListProductByPriceMinMax(@Param("min") double min, @Param("max") double max);

    @Query("select art from Product art where art.actif=1 and art.designation like :x")
    List<Product> findProductByKeyword(@Param("x") String mc);

    @Query("select p from Product p")
    Page<Product> findProductByPageable(Pageable pageable);

    @Query("select p from Product p where p.subcategory.id =:subCat")
    Page<Product> findProductBySubcategoryByPageable(@Param("subCat") Long subCat, Pageable pageable);

    @Query("select p from Product p where p.subcategory.subCategoryName =:subCatName")
    Page<Product> findProductBySubcategoryNameByPageable(@Param("subCatName") String subCatName, Pageable pageable);

    @Query("select art from Product art where art.price like :price GROUP BY (art.price, art.id) ")
    Page<Product> findProductPageableGroupByPrice(@Param("price") double price, Pageable pageable);

    @Query("Select DISTINCT act from Product act where act.actif=1 ORDER BY act.designation")
    List<Product> findAll();
}
