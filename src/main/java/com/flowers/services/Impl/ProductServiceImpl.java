package com.flowers.services.Impl;

import com.flowers.models.Product;
import com.flowers.reposiory.ProductRepository;
import com.flowers.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> findProductById(Long prodId) {
        return Optional.empty();
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long prodId, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long prodId) {

    }

    @Override
    public Product findByReference(String reference) {
        return null;
    }

    @Override
    public Product findByDesignation(String designation) {
        return null;
    }

    @Override
    public Product findByPrixAchat(double prixAchat) {
        return null;
    }

    @Override
    public List<Product> findAllProducts() {
        return null;
    }

    @Override
    public List<Product> findListProductByDesignation(String designation) {
        return null;
    }

    @Override
    public List<?> countNumberOfProductWithStock() {
        return null;
    }

    @Override
    public Integer countNumbersOfProductsByStock() {
        return null;
    }

    @Override
    public Integer countNumbersOfProductsWhenQStockEqualStockInit() {
        return null;
    }

    @Override
    public Integer countNumbersOfProductsWhenQStockInfStockInit() {
        return null;
    }
}
