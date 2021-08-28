package com.flowers.services.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.exceptions.ResourceNotFoundException;
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
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product saveProduct(Product product) {

        if (product.getReference() != null) {
            throw new ResourceNotFoundException("Product already exists");
        }
        return productRepository.save(product);

    }

    @Override
    public Product saveProductWithFile(String product, MultipartFile photoProduct) throws IOException {
        Product productMapper = new ObjectMapper().readValue(product, Product.class);
        System.out.println(productMapper);

        productMapper.setImageUrl(photoProduct.getOriginalFilename());

        return this.saveProduct(productMapper);
    }

    @Override
    public Product update(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product that id is " + id + "not found");
        }
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByReference(String reference) {
        if (productRepository.findByReference(reference) != null) {
            throw new ResourceNotFoundException("Product that id reference " + reference + "not found");
        }
        return productRepository.findByReference(reference);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findListProductBySubCategories(Long subCatId) {
        return productRepository.findProductBySubCategory(subCatId);
    }

    @Override
    public List<Product> findListProductByKeyword(String keyword) {
        return productRepository.findProductByKeyword(keyword);
    }

    @Override
    public List<Product> findListProductGroupByPrice(double price) {
        return productRepository.findProductGroupByPrice(price);
    }

    @Override
    public List<Product> findListProductBySelected() {
        return productRepository.findProductBySelected();
    }

    @Override
    public Page<Product> findProductByPageable(Pageable pageable) {
        return productRepository.findProductByPageable(pageable);
    }

    @Override
    public Page<Product> findProductBySubCategoryPageable(Long scatId, Pageable pageable) {
        return productRepository.findProductBySubCategoryByPageable(scatId, pageable);
    }

    @Override
    public Page<Product> findProductBySamePricePageable(double price, Pageable pageable) {
        return productRepository.findProductPageableGroupByPrice(price, pageable);
    }


    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found");
        }
        productRepository.deleteById(id);
    }
}
