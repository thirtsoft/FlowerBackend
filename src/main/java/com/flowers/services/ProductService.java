package com.flowers.services;

import com.flowers.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    Product saveProductWithFile(String product, MultipartFile photoProduct) throws IOException;

    Product update(Long id, Product product);

    Product findById(Long id);

    Product findByReference(String reference);

    List<Product> findAll();

    List<Product> findListProductBySubCategories(Long subCatId);

    List<Product> findListProductByKeyword(String keyword);

    List<Product> findListProductGroupByPrice(double price);

    List<Product> findListProductBySelected();

    Page<Product> findProductByPageable(Pageable pageable);

    Page<Product> findProductBySubCategoryPageables(Long scatId, Pageable pageable);

    Page<Product> findProductBySamePricePageables(double price, Pageable pageable);

    void delete(Long id);

}
