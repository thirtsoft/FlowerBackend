package com.flowers.services.Impl;

import com.flowers.models.Product;
import com.flowers.reposiory.ProductRepository;
import com.flowers.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public Product saveProductWithFile(String product, MultipartFile photoProduct) throws IOException {
        return null;
    }

    @Override
    public Product update(Long id, Product product) {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Product findByReference(String reference) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> findListProductBySubCategories(Long subCatId) {
        return null;
    }

    @Override
    public List<Product> findListProductByKeyword(String keyword) {
        return null;
    }

    @Override
    public List<Product> findListProductGroupByPrice(double price) {
        return null;
    }

    @Override
    public List<Product> findListProductBySelected() {
        return null;
    }

    @Override
    public Page<Product> findProductByPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Product> findProductBySubCategoryPageables(Long scatId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Product> findProductBySamePricePageables(double price, Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
