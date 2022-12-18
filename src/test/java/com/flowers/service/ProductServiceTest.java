package com.flowers.service;


import com.flowers.dtos.NewsletterDto;
import com.flowers.dtos.ProductDto;
import com.flowers.models.Product;
import com.flowers.models.Subcategory;
import com.flowers.reposiory.ProductRepository;
import com.flowers.reposiory.SubcategoryRepository;
import com.flowers.services.Impl.ProductServiceImpl;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private SubcategoryRepository subcategoryRepository;

    @Test
    public void should_save_one_product() {
        Product product = new Product();
        product.setId(1L);
        product.setReference("Prod1");
        product.setDesignation("Product1");
        product.setPrice(45);
        product.setQuantity(2);

        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductDto productDto = productService.saveProduct(ProductDto.fromEntityToDto(new Product()));

        Product productResult = ProductDto.fromDtoToEntity(productDto);

        assertThat(productResult).usingRecursiveComparison().isEqualTo(product);
        verify(productRepository, times(1)).save(any(Product.class));
        verifyNoMoreInteractions(productRepository);
    }

    /*
    @Test
    public void should_find_and_return_one_product() {
        Product product = new Product();
        product.setReference("Prod2");
        product.setDesignation("Product2");
        product.setPrice(45);
        product.setQuantity(2);

        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        ProductDto productDtoResult = productService.findById(anyLong());

        Product productResult = ProductDto.fromDtoToEntity(productDtoResult);

        assertThat(productResult).usingRecursiveComparison().isEqualTo(product);
        verify(productRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void should_update_product() {
        Subcategory subcategory = new Subcategory();
        subcategory.setSubCategoryName("Subcat3");
        subcategory.setDescription("Subcat3");
        subcategoryRepository.save(subcategory);
        Product product = new Product();
        product.setId(3L);
        product.setReference("Prod3");
        product.setDesignation("Product3");
        product.setPrice(45);
        product.setQuantity(2);
        product.setSubcategory(subcategory);

        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        ProductDto productDtoResult = productService.findById(anyLong());
        productDtoResult.setReference("Product002");
        productService.saveProduct(productDtoResult);

        Product productResult = ProductDto.fromDtoToEntity(productDtoResult);

        assertThat(productResult).usingRecursiveComparison().isNotEqualTo(product);
        assertThat(productResult.getReference()).isEqualTo("Product002");

    }

     */


    @Test
    public void should_find_and_return_all_products() {
        Subcategory subcategory = new Subcategory();
        subcategory.setSubCategoryName("Subcat4");
        subcategory.setDescription("Subcat4");
        subcategoryRepository.save(subcategory);
        Product product = new Product();
        product.setId(4L);
        product.setReference("Prod4");
        product.setDesignation("Product4");
        product.setPrice(45);
        product.setQuantity(2);
        product.setSubcategory(subcategory);

        when(productRepository.findAll()).thenReturn(singletonList(product));

        List<ProductDto> productList = productService.findAll();

        assertThat(productList).isNotNull();
        assertThat(productList).hasSize(1);
        verify(productRepository, times(1)).findAll();
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void should_find_and_return_all_products_by_Id_desc() {
        Subcategory subcategory = new Subcategory();
        subcategory.setSubCategoryName("Subcat5");
        subcategory.setDescription("Subcat5");
        subcategoryRepository.save(subcategory);
        Product product = new Product();
        product.setId(5L);
        product.setReference("Prod5");
        product.setDesignation("Product5");
        product.setPrice(45);
        product.setQuantity(2);
        product.setSubcategory(subcategory);

        when(productRepository.findByOrderByIdDesc()).thenReturn(singletonList(product));

        List<ProductDto> productList = productService.findByOrderByIdDesc();

        assertThat(productList).isNotNull();
        assertThat(productList).hasSize(1);
        verify(productRepository, times(1)).findByOrderByIdDesc();
        verifyNoMoreInteractions(productRepository);

    }

    @Test
    public void should_and_return_all_selected_products() {
        Product product = new Product();
        product.setId(6L);
        product.setReference("Prod6");
        product.setDesignation("Product6");
        product.setPrice(45);
        product.setQuantity(2);
        product.setSelected(true);

        when(productRepository.findProductBySelected()).thenReturn(singletonList(product));

        List<ProductDto> productList = productService.findListProductBySelected();

        assertThat(productList).hasSize(1);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
        verify(productRepository, times(1)).findProductBySelected();
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void should_and_return_all_products_in_promo() {
        Product product = new Product();
        product.setId(7L);
        product.setReference("Prod7");
        product.setDesignation("Product7");
        product.setPrice(45);
        product.setQuantity(2);
        product.setSelected(true);
        product.setPromo(true);

        when(productRepository.findProductByPromo()).thenReturn(singletonList(product));

        List<ProductDto> productList = productService.findListProductByPromo();

        assertThat(productList).hasSize(1);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
        verify(productRepository, times(1)).findProductByPromo();
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void should_and_return_top24_products() {
        Product product = new Product();
        product.setId(8L);
        product.setReference("Prod8");
        product.setDesignation("Product8");
        product.setPrice(45);
        product.setQuantity(2);
        product.setSelected(true);
        product.setPromo(true);

        when(productRepository.findTop24ByOrderByCreatedDateDesc()).thenReturn(singletonList(product));

        List<ProductDto> productList = productService.findTop24ByOrderByCreateDateDesc();

        assertThat(productList).hasSize(1);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
        verify(productRepository, times(1)).findTop24ByOrderByCreatedDateDesc();
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void should_and_return_products_by_subcategory_id() {

        Long catId = 1L;

        when(productRepository.findProductBySubcategory(catId)).thenReturn(singletonList(any()));

        List<ProductDto> productList = productService.findListProductBySubCategories(catId);

        assertThat(productList).hasSize(1);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
        verify(productRepository, times(1)).findProductBySubcategory(catId);
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void should_and_return_products_groupe_by_price() {
        double price = 1L;
        when(productRepository.findProductGroupByPrice(price)).thenReturn(singletonList(any()));

        List<ProductDto> productList = productService.findListProductGroupByPrice(price);

        assertThat(productList).hasSize(1);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
        verify(productRepository, times(1)).findProductGroupByPrice(price);
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void should_and_return_products_by_keyword() {
        String keyword = "Fleur";
        when(productRepository.findProductByKeyword(keyword)).thenReturn(singletonList(any()));

        List<ProductDto> productList = productService.findListProductByKeyword(keyword);

        assertThat(productList).hasSize(1);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
        verify(productRepository, times(1)).findProductByKeyword(keyword);
        verifyNoMoreInteractions(productRepository);
    }

    /*
    @Test
    public void should_and_return_all_products_by_pageable() {
        int page = 2;
        int size = 2;
        Pageable pageable = PageRequest.of(page, size);
        when(productRepository.findAll(pageable)).thenReturn(any());

        List<ProductDto> productListDto = productService.findProductByPageable(page, size).;

        assertThat(productListDto).hasSize(1);
        assertThat(productListDto.size()).isNotNull();
        assertThat(productListDto.size()).isGreaterThanOrEqualTo(0);
        verify(productRepository, times(1)).findAll(pageable).getContent();
        verifyNoMoreInteractions(productRepository);
    }
    */

    /*
    @Test
    public void should_and_return_all_products_by_keyword_by_pageable() {
        int page = 2;
        int size = 2;
        String keyword = "Fleur";
        Pageable pageable = PageRequest.of(page, size);
        when(productRepository.findByDesignationContaining(keyword, pageable).getContent()).thenReturn(singletonList(any()));

        List<ProductDto> productListDto = productService.findProductByKeywordByPageable(keyword, page, size);

        assertThat(productListDto).hasSize(1);
        assertThat(productListDto.size()).isNotNull();
        assertThat(productListDto.size()).isGreaterThanOrEqualTo(0);
        verify(productRepository, times(1)).findByDesignationContaining(keyword, pageable).getContent();
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void should_and_return_all_products_by_subcategories_by_pageable() {
        int page = 2;
        int size = 2;
        Long catId = 1L;
        Pageable pageable = PageRequest.of(page, size);
        when(productRepository.findProductBySubcategoryByPageable(catId, pageable)).thenReturn(any());

        List<ProductDto> productListDto = productService.findProductsBySubCategoryId(catId, page, size);

        assertThat(productListDto.size()).isNotNull();
        assertThat(productListDto.size()).isGreaterThanOrEqualTo(0);
        verify(productRepository, times(1)).findProductBySubcategoryByPageable(catId, pageable);
        verifyNoMoreInteractions(productRepository);
    }


     */
    @Test
    public void should_and_return_products_by_subcategory_length() {
        Long subCatId = 1L;
        when(productRepository.getOrderLengthBySubcategoryId(subCatId)).thenReturn(anyLong());

        long number = productService.getProductsByCategoryIdLength(subCatId);
        long val = 200000;

        assertThat(number).isLessThan(val);
        assertThat(number).usingRecursiveComparison().isNotEqualTo(val);
        verify(productRepository, times(1)).getOrderLengthBySubcategoryId(subCatId);
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void should_and_return_products_by_keyword_length() {
        String keyword = "Fleur";
        when(productRepository.getOrderSizeByKey(keyword)).thenReturn(anyLong());

        long number = productService.getProductSizeByKey(keyword);
        long val = 200000;

        assertThat(number).isLessThan(val);
        assertThat(number).usingRecursiveComparison().isNotEqualTo(val);
        verify(productRepository, times(1)).getOrderSizeByKey(keyword);
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void should_and_return_products_by_size_length() {
        when(productRepository.count()).thenReturn(1L);

        long number = productService.getAllProductsSize();
        long val = 200000020;

        assertThat(number).usingRecursiveComparison().isNotEqualTo(val);
        verify(productRepository, times(1)).count();
        verifyNoMoreInteractions(productRepository);
    }


    @Test
    public void should_delete_one_product() {
        doNothing().when(productRepository).deleteById(anyLong());

        productService.delete(anyLong());
        verify(productRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(productRepository);
    }


}
