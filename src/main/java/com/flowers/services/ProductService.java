package com.flowers.services;

import com.flowers.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product saveProduct(Product product);

    Product saveProductWithFile(String product, MultipartFile photoProduct) throws IOException;

    Product update(Long id, Product product);

    Optional<Product> findById(Long id);

    Optional<Product> findByReference(String reference);

    List<Product> findAll();

    List<Product> findListProductBySubCategories(Long subCatId);

    List<Product> findListProductByKeyword(String keyword);

    List<Product> findListProductGroupByPrice(double price);

    List<Product> findListProductBySelected();

    List<Product> findListProductByPromo();

    List<Product> findTop24ByOrderByCreateDateDesc();

    List<Product> findByOrderByIdDesc();

    List<Product> findListProductByPriceMinMax(double min, double max);

    Page<Product> findProductByPageable(Pageable pageable);

    Page<Product> findProductBySubCategoryPageable(Long scatId, Pageable pageable);

    Page<Product> findProductBySamePricePageable(double price, Pageable pageable);

    void delete(Long id);


}
