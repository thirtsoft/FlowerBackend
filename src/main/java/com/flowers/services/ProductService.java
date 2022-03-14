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

    List<ProductDto> findListProductByKeyword(String keyword);

    List<ProductDto> findListProductGroupByPrice(double price);

    List<ProductDto> findListProductBySelected();

    List<ProductDto> findListProductByPromo();

    List<ProductDto> findTop24ByOrderByCreateDateDesc();

    List<ProductDto> findByOrderByIdDesc();

    List<ProductDto> findListProductByPriceMinMax(double min, double max);

    Page<ProductDto> findProductByPageable(Pageable pageable);

    Page<ProductDto> findProductBySubCategoryPageable(Long scatId, Pageable pageable);

    Page<ProductDto> findProductBySamePricePageable(double price, Pageable pageable);

    void delete(Long id);


}
