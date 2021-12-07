package com.flowers.services.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Product;
import com.flowers.reposiory.ProductRepository;
import com.flowers.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
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
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product that id is" + id + "is not found");
        }
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (!optionalProduct.isPresent()) {
            throw new ResourceNotFoundException("Product not found");
        }

        Product productResult = optionalProduct.get();
        productResult.setReference(product.getReference());
        productResult.setProductName(product.getProductName());
        productResult.setQuantity(product.getQuantity());
        productResult.setPrice(product.getPrice());
        productResult.setCurrentPrice(product.getCurrentPrice());
        productResult.setInstock(product.isInstock());
        productResult.setSelected(product.isSelected());
        productResult.setPromo(product.isPromo());
        productResult.setDescription(product.getDescription());
        productResult.setManufactured(product.getManufactured());
        productResult.setSubcategory(product.getSubcategory());


        return productRepository.save(productResult);
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
        if (!StringUtils.hasLength(reference)) {
            log.error("Product REFERENCE is null");
        }

        return productRepository.findProductByReference(reference);
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
