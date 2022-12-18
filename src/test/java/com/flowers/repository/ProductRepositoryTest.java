package com.flowers.repository;

import com.flowers.models.Product;
import com.flowers.reposiory.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_product_Test() {
        Product product = new Product();
        product.setReference("PROD01");
        product.setDesignation("Product01");
        product.setPrice(5500);
        product.setQuantity(10);
        product.isSelected();
        productRepository.save(product);

        assertThat(product.getId()).isGreaterThan(0);
        assertThat(product.getReference()).isNotNull();
        assertThat(product.getDesignation()).isEqualTo("Product01");
    }

    /*
    @Test
    @Order(2)
    @Rollback(value = false)
    public void save_product_with_file_Test() throws IOException {
        String product = new JSONParser("producit00010000");
        Product productResult = new ObjectMapper().readValue(product, Product.class);
        MultipartFile photoProduct = null;
        productResult.setImageUrl(photoProduct.getOriginalFilename());
        productRepository.save(productResult);

        assertThat(productResult.getId()).isGreaterThan(0);
        assertThat(productResult.getReference()).isNotNull();
        assertThat(productResult.getDesignation()).isNotNull();
    }*/

    @Test
    @Order(3)
    public void get_and_return_on_product_by_Id_Test() {
        Product product = new Product();
        product.setReference("PRODBYREF");
        product.setDesignation("Product01");
        product.setPrice(5500);
        product.setQuantity(10);
        product.isSelected();
        productRepository.save(product);

        Product optionalProduct = productRepository.findById(product.getId()).get();

        assertThat(optionalProduct.getId()).isEqualTo(product.getId());
        assertThat(optionalProduct.getReference()).isEqualTo(product.getReference());
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void get_and_return_on_product_by_reference_Test() {
        Product product = new Product();
        product.setReference("PRODBYREFERENCE");
        product.setDesignation("Product01");
        product.setPrice(5500);
        product.setQuantity(10);
        product.isSelected();
        productRepository.save(product);
        String reference = "PRODBYREFERENCE";

        Product optionalProduct = productRepository.findProductByReference(reference).get();

        assertThat(optionalProduct.getId()).isEqualTo(product.getId());
        assertThat(optionalProduct.getReference()).isEqualTo(product.getReference());
        assertThat(optionalProduct.getDesignation()).isEqualTo("Product01");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void update_product_by_id_Test() {
        Optional<Product> optionalProduct = productRepository.findById(1L);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setDesignation("Product003");

            Product productUpdated = productRepository.save(product);
            assertThat(productUpdated.getId()).isEqualTo(product.getId());
            assertThat(productUpdated.getDesignation()).isEqualTo("Product003");
        }
    }


    @Test
    @Order(6)
    public void get_number_Of_product_Test() {
        long number = productRepository.count();
        long val = 200000;
        assertThat(number).isLessThan(val);
    }

    @Test
    @Order(7)
    public void should_and_return_all_products_Test() {
        Product product = new Product();
        product.setReference("PRODALLPRODUCTS");
        product.setDesignation("Product00004");
        product.setPrice(5500);
        product.setQuantity(10);
        product.isSelected();
        productRepository.save(product);

        List<Product> productList = productRepository.findAll();

        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(8)
    public void should_and_return_all_products_by_IdDesc_Test() {
        Product product = new Product();
        product.setReference("PRODALLPRODUCTSIDDES");
        product.setDesignation("Product00004");
        product.setPrice(5500);
        product.setQuantity(10);
        product.isSelected();
        productRepository.save(product);

        List<Product> productList = productRepository.findByOrderByIdDesc();

        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(9)
    public void should_and_return_all_selected_products_Test() {
        Product product = new Product();
        product.setReference("PRODSELECTEDPRODUCTS");
        product.setDesignation("Product00005");
        product.setPrice(5500);
        product.setQuantity(10);
        product.setSelected(true);
        productRepository.save(product);

        List<Product> productList = productRepository.findProductBySelected();

        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(10)
    public void should_and_return_all_products_by_promo_Test() {
        Product product = new Product();
        product.setReference("PRODPROMOPRODUCTS");
        product.setDesignation("Product00006");
        product.setPrice(5500);
        product.setQuantity(10);
        product.setPromo(true);
        productRepository.save(product);

        List<Product> productList = productRepository.findProductByPromo();

        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(11)
    public void should_and_return_top24_products_order_desc_Test() {
        Product product = new Product();
        product.setReference("PRODTOP24PRODUCTS");
        product.setDesignation("Product00006");
        product.setPrice(5500);
        product.setQuantity(10);
        productRepository.save(product);

        List<Product> productList = productRepository.findTop24ByOrderByCreatedDateDesc();

        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(12)
    public void should_and_return_products_by_subcategory_id_Test() {
        Long subCatId = 1L;
        List<Product> productList = productRepository.findProductBySubcategory(subCatId);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(13)
    public void should_and_return_products_groupe_by_price_Test() {
        double price = 15000L;
        List<Product> productList = productRepository.findProductGroupByPrice(price);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(14)
    public void should_and_return_products_by_keyword_Test() {
        String keyword = "Fleur de mariage";
        List<Product> productList = productRepository.findProductByKeyword(keyword);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(15)
    public void should_and_return_products_by_price_min_max_Test() {
        double priceMin = 15000;
        double priceMax = 25000;
        List<Product> productList = productRepository.findListProductByPriceMinMax(priceMin, priceMax);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }

    /*
    @Test
    @Order(16)
    public void should_and_return_products_by_pageable_Test() {
        Pageable pageable = null;
        List<Product> productList = (List<Product>) productRepository.findProductByPageable(pageable);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(17)
    public void should_and_return_products_by_subcategory_by_pageable_Test() {
        Pageable pageable = null;
        Long subCatId = 1L;
        List<Product> productList = (List<Product>) productRepository.findBySubcategory(subCatId, pageable);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThan(0);
    }

    @Test
    @Order(18)
    public void should_and_return_products_by_same_price_by_pageable_Test() {
        Pageable pageable = null;
        double price = 250000;
        List<Product> productList = (List<Product>) productRepository.findProductPageableGroupByPrice(price, pageable);
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThan(0);
    }


     */
    @Test
    @Order(19)
    public void should_and_return_all_products_by_pageable_Test() {
        int page = 2;
        int size = 2;
        Pageable pageable = PageRequest.of(page, size);
        List<Product> productList = productRepository.findAll(pageable).getContent();
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(20)
    public void should_and_return_products_by_keyword_by_pageables_Test() {
        int page = 2;
        int size = 2;
        String keyword = "Fleur";
        Pageable pageable = PageRequest.of(page, size);
        List<Product> productList = productRepository.findByDesignationContaining(keyword, pageable).getContent();
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(21)
    public void should_and_return_products_by_subcategories_by_pageable_Test() {
        int page = 2;
        int size = 2;
        Long subCatId = 1L;
        Pageable pageable = PageRequest.of(page, size);
        List<Product> productList = productRepository.findProductBySubcategoryByPageable(subCatId, pageable).getContent();
        assertThat(productList.size()).isNotNull();
        assertThat(productList.size()).isGreaterThanOrEqualTo(0);
    }


    @Test
    @Order(21)
    public void get_products_by_subcategory_length_Test() {
        Long subCatId = 1L;
        long number = productRepository.getOrderLengthBySubcategoryId(subCatId);
        long val = 200000;
        assertThat(number).isLessThan(val);
    }

    @Test
    @Order(22)
    public void get_products_size_by_keyword_Test() {
        String keyword = "keyword";
        long number = productRepository.getOrderSizeByKey(keyword);
        long val = 200000;
        assertThat(number).isLessThan(val);
    }

    @Test
    @Order(23)
    public void get_and_return_all_by_size_Test() {
        long number = productRepository.count();
        long val = 200000;
        assertThat(number).isLessThan(val);
    }

    @Test
    @Order(24)
    @Rollback(value = false)
    public void delete_product_by_id_Test() {
        Optional<Product> optionalProduct = productRepository.findById(1L);
        if (optionalProduct.isPresent()) {
            productRepository.delete(optionalProduct.get());
        }
        Product product = null;
        Optional<Product> optionalProduct01 = productRepository.findById(1L);
        if (optionalProduct01.isPresent()) {
            product = optionalProduct01.get();
        }
        assertThat(product).isNull();
    }

}
