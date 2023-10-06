package com.flowers.services;

import com.flowers.dtos.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    ProductDto saveProduct(ProductDto productDto);

    ProductDto saveProductWithFile(String product, MultipartFile photoProduct) throws IOException;

    ProductDto update(Long id, ProductDto productDto);

    ProductDto findById(Long id);

    ProductDto findByReference(String reference);

    long countNumberTotalOfProduct();

    List<ProductDto> findAll();

    List<ProductDto> findListProductBySubCategories(Long subCatId);

    List<ProductDto> findListProductBySubCategoryName(String subCatName);

    List<ProductDto> findListProductByKeyword(String keyword);

    List<ProductDto> findListProductBySelected();

    List<ProductDto> findListProductByPromo();

    List<ProductDto> findTop24ByOrderByCreateDateDesc();

    List<ProductDto> findTop3ByOrderByIdDesc();

    List<ProductDto> findTop4ByOrderByIdDesc();

    List<ProductDto> findTop8ByOrderByIdDesc();

    Page<ProductDto> findProductByPageable(Pageable pageable);

    Page<ProductDto> findProductBySubCategoryPageable(Long scatId, Pageable pageable);

    List<ProductDto> findProductByPageable(int page, int size);

    List<ProductDto> findProductByKeywordByPageable(String keyword, int page, int size);

    List<ProductDto> findProductsBySubCategoryId(Long scatId, int page, int size);

    List<ProductDto> findProductsBySubCategoryName(String scatName, int page, int size);

    long getProductsByCategoryIdLength(Long id);

    long getProductsByCategoryNameLength(String subcatName);

    long getProductSizeByKey(String key);

    long getAllProductsSize();

    List<ProductDto> findAllActiveProducts();

    List<ProductDto> findListProductsByFournisseur(Long fournisseurId);

    void deleteProduct(Long prodId);

}
