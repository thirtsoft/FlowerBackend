package com.flowers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.controllers.api.ProductApi;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Product;
import com.flowers.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController implements ProductApi {

    private final ProductService productService;

    private final String productPhotosDir = "C://Users//Folio9470m//flowers//photos//";

    @Override
    public ResponseEntity<Product> save(Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @Override
    public ResponseEntity<Product> saveProductWithFile(String product, MultipartFile photoProduct) throws IOException {
        Product productMapper = new ObjectMapper().readValue(product, Product.class);
        if (photoProduct != null && !photoProduct.isEmpty()) {
            productMapper.setImageUrl(photoProduct.getOriginalFilename());
            photoProduct.transferTo(new File(productPhotosDir + photoProduct.getOriginalFilename()));
        }

        return ResponseEntity.ok(productService.saveProduct(productMapper));
    }

    @Override
    public ResponseEntity<Product> update(Long id, Product product) {
        product.setId(id);
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id) throws ResourceNotFoundException {
        Product product = productService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return ResponseEntity.ok().body(product);
    }

    @Override
    public ResponseEntity<Product> getProductByReference(String reference) {
        Product product = productService.findByReference(reference)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return ResponseEntity.ok().body(product);
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @Override
    public ResponseEntity<List<Product>> getListProductBySubCategory(Long subCatId) {
        return ResponseEntity.ok(productService.findListProductBySubCategories(subCatId));
    }

    @Override
    public ResponseEntity<List<Product>> getListProductByKeyword(String keyword) {
        return ResponseEntity.ok(productService.findListProductByKeyword("%" + keyword + "%"));
    }

    @Override
    public ResponseEntity<List<Product>> getListProductByPrice(double price) {
        return ResponseEntity.ok(productService.findListProductGroupByPrice(price));
    }

    @Override
    public ResponseEntity<List<Product>> getListProductBySelected() {
        return ResponseEntity.ok(productService.findListProductBySelected());
    }

    @Override
    public ResponseEntity<List<Product>> getListProductByPromo() {
        List<Product> productList = productService.findListProductByPromo();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Product>> getTop24ByOrderByCreatedDateDesc() {
        List<Product> productList = productService.findTop24ByOrderByCreateDateDesc();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Product>> getAllProductByOrderByIdDesc() {
        List<Product> productList = productService.findByOrderByIdDesc();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Product>> getAllProductByPriceMinMax(double min, double max) {
        List<Product> productList = productService.findListProductByPriceMinMax(min, max);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @Override
    public Page<Product> getListProductByPageable(Pageable pageable) {
        return productService.findProductByPageable(pageable);
    }

    @Override
    public Page<Product> getListProductBySubCategoryByPageable(Long scatId, Pageable pageable) {
        return productService.findProductBySubCategoryPageable(scatId, pageable);
    }

    @Override
    public Page<Product> getListProductBySamePriceyByPageable(double price, Pageable pageable) {
        return productService.findProductBySamePricePageable(price, pageable);
    }

    @Override
    public void delete(Long id) {
        productService.delete(id);
    }

    @Override
    public byte[] getPhotoProduct(Long id) throws Exception {
        Product product = productService.findById(id).get();

        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/flowers//photos/" + product.getImageUrl()));
    }

    @Override
    public void uploadPhotoProduct(MultipartFile photoProduct, Long idProduct) throws IOException {

    }
}
