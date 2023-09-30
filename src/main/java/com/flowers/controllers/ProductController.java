package com.flowers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.controllers.api.ProductApi;
import com.flowers.dtos.ProductDto;
import com.flowers.services.ProductService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(origins = {"https://fleurpourtous.com", "https://portail.fleurpourtous.com"})
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class ProductController implements ProductApi {

    private static final String productPhotosDir = System.getProperty("user.home") + "/flowers/photos/";
    private final ProductService productService;
    @Autowired
    ServletContext context;


    @Override
    public ResponseEntity<ProductDto> saveProduct(ProductDto productDto) {
        ProductDto productDtoResult = productService.saveProduct(productDto);
        return new ResponseEntity<>(productDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductDto> saveProductWithFile(String product, MultipartFile photoProduct) throws IOException {
        ProductDto productDto = new ObjectMapper().readValue(product, ProductDto.class);
        if (photoProduct != null && !photoProduct.isEmpty()) {
            productDto.setPhoto(photoProduct.getOriginalFilename());
            photoProduct.transferTo(new File(productPhotosDir + photoProduct.getOriginalFilename()));
        }
        ProductDto productDtoResult = productService.saveProduct(productDto);
        return new ResponseEntity<>(productDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductDto> saveProductWithFilesInFolder(
            String product,
            MultipartFile photoProduct) throws IOException {
        ProductDto productDto = new ObjectMapper().readValue(product, ProductDto.class);
        if (photoProduct != null && !photoProduct.isEmpty()) {
            String filename = photoProduct.getOriginalFilename();
            String newFileName = FilenameUtils.getBaseName(filename) + "." + FilenameUtils.getExtension(filename);
            File serverFile = new File(context.getRealPath("/Fleurs/photos/" + File.separator + newFileName));
            FileUtils.writeByteArrayToFile(serverFile, photoProduct.getBytes());
            productDto.setPhoto(filename);
        }
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }

    @Override
    public ResponseEntity<ProductDto> updateProduct(Long id, ProductDto productDto) {
        productDto.setId(id);
        ProductDto productDtoResult = productService.saveProduct(productDto);
        return new ResponseEntity<>(productDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> getProductById(Long id) {
        ProductDto productDtoResult = productService.findById(id);
        return new ResponseEntity<>(productDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> getProductByReference(String reference) {
        ProductDto productDtoResult = productService.findByReference(reference);
        return new ResponseEntity<>(productDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList = productService.findAll();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getListProductBySubCategory(Long subCatId) {
        List<ProductDto> productDtoList = productService.findListProductBySubCategories(subCatId);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getListProductByKeyword(String keyword) {
        List<ProductDto> productDtoList = productService.findListProductByKeyword("%" + keyword + "%");
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getListProductBySelected() {
        List<ProductDto> productDtoList = productService.findListProductBySelected();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getTop24ByOrderByCreatedDateDesc() {
        List<ProductDto> productDtoList = productService.findTop24ByOrderByCreateDateDesc();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getTop3ByOrderByIdDesc() {
        List<ProductDto> productDtoList = productService.findTop3ByOrderByIdDesc();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getTop4ByOrderByIdDesc() {
        List<ProductDto> productDtoList = productService.findTop4ByOrderByIdDesc();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getTop8ByOrderByIdDesc() {
        List<ProductDto> productDtoList = productService.findTop8ByOrderByIdDesc();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public Page<ProductDto> getListProductByPageable(int page, int size) {
        final Pageable pageable = PageRequest.of(page, size);
        return productService.findProductByPageable(pageable);
    }

    @Override
    public Page<ProductDto> getListProductBySubCategoryByPageable(Long scatId, int page, int size) {
        final Pageable pageable = PageRequest.of(page, size);
        return productService.findProductBySubCategoryPageable(scatId, pageable);
    }

    @Override
    public byte[] getPhotoProduct(Long id) throws Exception {
        ProductDto productDto = productService.findById(id);
        return Files.readAllBytes(Paths.get(productPhotosDir + productDto.getPhoto()));
    }

    @Override
    public byte[] getPhotoProductInFolder(Long id) throws Exception {
        ProductDto productDto = productService.findById(id);
        return Files.readAllBytes(Paths.get(context.getRealPath("/Fleurs/photos/") + productDto.getPhoto()));
    }

    @Override
    public void uploadPhotoProduct(MultipartFile photoProduct, Long idProduct) throws IOException {
        ProductDto productDto = productService.findById(idProduct);
        productDto.setPhoto(photoProduct.getOriginalFilename());
        Files.write(Paths.get(productPhotosDir + productDto.getPhoto()), photoProduct.getBytes());
        productService.saveProduct(productDto);
    }

    @Override
    public void uploadPhotoProductInFolder(MultipartFile file, Long id) throws IOException {
        ProductDto productDto = productService.findById(id);
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename) + "." + FilenameUtils.getExtension(filename);
        File serverFile = new File(context.getRealPath("/Fleurs/photos/" + File.separator + newFileName));
        try {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
            productDto.setPhoto(filename);
            productService.saveProduct(productDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public long getNumberTotalOfProductInDatabase() {
        return productService.countNumberTotalOfProduct();
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProductsByPageable(int page, int size) {
        List<ProductDto> productDtoList = productService.findProductByPageable(page, size);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProductsBySuCategoryIdByPageable(Long id, int page, int size) {
        List<ProductDto> productDtoList = productService.findProductsBySubCategoryId(id, page, size);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProductsBySuCategoryNameByPageable(String subCatName, int page, int size) {
        List<ProductDto> productDtoList = productService.findProductsBySubCategoryName(subCatName, page, size);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProductsByKeywordByPageable(String keyword, int page, int size) {
        List<ProductDto> productDtoList = productService.findProductByKeywordByPageable(keyword, page, size);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public long getProductSizes() {
        return productService.getAllProductsSize();
    }

    @Override
    public long getProductSizesBySubCategoryId(Long id) {
        return productService.getProductsByCategoryIdLength(id);
    }

    @Override
    public long getProductSizesBySubCategorySubCategoryName(String subcatName) {
        return productService.getProductsByCategoryNameLength(subcatName);
    }

    @Override
    public long getProductSizesByKeyword(String key) {
        return productService.getProductSizeByKey(key);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllActiveProducts() {
        List<ProductDto> productDtoList = productService.findAllActiveProducts();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getListProductBySubCategoryName(String subCatName) {
        List<ProductDto> productDtoList = productService.findListProductBySubCategoryName("%" + subCatName + "%");
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteProduct(Long idProduct) {
        productService.deleteProduct(idProduct);
    }

}
