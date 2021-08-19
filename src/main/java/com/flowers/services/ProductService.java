package com.flowers.services;

import com.flowers.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findProductById(Long prodId);

    Product saveProduct(Product product);

    Product updateProduct(Long prodId, Product product);

    void deleteProduct(Long prodId);

    Product findByReference(String reference);

    Product findByDesignation(String designation);

    Product findByPrixAchat(double prixAchat);

    List<Product> findAllProducts();

    List<Product> findListProductByDesignation(String designation);

    List<?> countNumberOfProductWithStock();

    Integer countNumbersOfProductsByStock();

    Integer countNumbersOfProductsWhenQStockEqualStockInit();

    Integer countNumbersOfProductsWhenQStockInfStockInit();

}
