package com.flowers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.controllers.api.ProductApi;
import com.flowers.dtos.ProductDto;
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
    public ResponseEntity<ProductDto> saveProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> saveProductWithFile(String product, MultipartFile photoProduct) throws IOException {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> updateProduct(Long id, ProductDto productDto) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> getProductById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> getProductByReference(String reference) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDto>> getListProductBySubCategory(Long subCatId) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDto>> getListProductByKeyword(String keyword) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDto>> getListProductByPrice(double price) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDto>> getListProductBySelected() {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDto>> getListProductByPromo() {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDto>> getTop24ByOrderByCreatedDateDesc() {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProductByOrderByIdDesc() {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProductByPriceMinMax(double min, double max) {
        return null;
    }

    @Override
    public Page<ProductDto> getListProductByPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductDto> getListProductBySubCategoryByPageable(Long scatId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductDto> getListProductBySamePriceyByPageable(double price, Pageable pageable) {
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
