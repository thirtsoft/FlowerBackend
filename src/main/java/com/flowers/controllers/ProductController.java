package com.flowers.controllers;

import com.flowers.controllers.api.ProductApi;
import com.flowers.models.Product;
import com.flowers.reposiory.ProductRepository;
import com.flowers.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;

    @Override
    public ResponseEntity<Product> save(Product product) {
        return null;
    }

    @Override
    public ResponseEntity<Product> saveProductWithFile(String product, MultipartFile photoProduct) throws IOException {
        return null;
    }

    @Override
    public ResponseEntity<Product> update(Long id, Product product) {
        return null;
    }

    @Override
    public ResponseEntity<Product> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Product> findByReference(String reference) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> findListProductByScategories(Long subCatId) {
        return null;
    }

    @Override
    public List<Product> getListProductByKeyword(String keyword) {
        return null;
    }

    @Override
    public List<Product> getListProductByPrice(double price) {
        return null;
    }

    @Override
    public List<Product> getListProductBySelected() {
        return null;
    }

    @Override
    public Page<Product> getListProductByPageable(int page, int size) {
        return null;
    }

    @Override
    public Page<Product> getListProductByScategoryByPageable(Long scatId, int page, int size) {
        return null;
    }

    @Override
    public Page<Product> getListProductBySamePriceyByPageable(double price, int page, int size) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public byte[] getPhotoProduct(Long id) throws Exception {
        return new byte[0];
    }

    @Override
    public void uploadPhotoProduct(MultipartFile photoProduct, Long idProduct) throws IOException {

    }
}
