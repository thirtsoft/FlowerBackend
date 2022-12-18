package com.flowers.services.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.dtos.ProductDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Product;
import com.flowers.reposiory.ProductRepository;
import com.flowers.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        return ProductDto.fromEntityToDto(
                productRepository.save(
                        ProductDto.fromDtoToEntity(productDto)
                )
        );
    }

    @Override
    public ProductDto saveProductWithFile(String product, MultipartFile photoProduct) throws IOException {
        ProductDto productDto = new ObjectMapper().readValue(product, ProductDto.class);
        System.out.println(productDto);

        productDto.setPhoto(photoProduct.getOriginalFilename());

        return ProductDto.fromEntityToDto(
                productRepository.save(
                        ProductDto.fromDtoToEntity(productDto)
                )
        );
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found");
        }

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (!optionalProduct.isPresent()) {
            throw new ResourceNotFoundException("Product not found");
        }

        ProductDto productDtoResult = ProductDto.fromEntityToDto(optionalProduct.get());
        productDtoResult.setReference(productDto.getReference());
        productDtoResult.setDesignation(productDto.getDesignation());
        productDtoResult.setPrice(productDto.getPrice());
        productDtoResult.setCurrentPrice(productDto.getCurrentPrice());
        productDtoResult.setQuantity(productDto.getQuantity());
        productDtoResult.setPhoto(productDto.getPhoto());
        productDtoResult.setSelected(productDto.isSelected());
        productDtoResult.setPromo(productDto.isPromo());
        productDtoResult.setDescription(productDto.getDescription());
        productDtoResult.setManufactured(productDto.getManufactured());
        productDtoResult.setSubCategoryDto(productDto.getSubCategoryDto());

        return ProductDto.fromEntityToDto(
                productRepository.save(
                        ProductDto.fromDtoToEntity(productDtoResult)
                )
        );
    }

    @Override
    public ProductDto findById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found");
        }

        Optional<Product> optionalProduct = productRepository.findById(id);

        return Optional.of(ProductDto.fromEntityToDto(optionalProduct.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun Product avec l'Id = " + id + "n'a été trouvé")
        );
    }

    @Override
    public ProductDto findByReference(String reference) {

        if (!StringUtils.hasLength(reference)) {
            log.error("Article REFERENCE is null");
        }

        Optional<Product> optionalProduct = productRepository.findProductByReference(reference);

        return Optional.of(ProductDto.fromEntityToDto(optionalProduct.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun Product avec l'Id = " + reference + "n'a été trouvé")
        );
    }

    @Override
    public long countNumberTotalOfProduct() {
        return productRepository.count();
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findListProductBySubCategories(Long subCatId) {
        return productRepository.findProductBySubcategory(subCatId).stream()
                .map(ProductDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findListProductByKeyword(String keyword) {
        return productRepository.findProductByKeyword(keyword).stream()
                .map(ProductDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findListProductGroupByPrice(double price) {
        return productRepository.findProductGroupByPrice(price).stream()
                .map(ProductDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findListProductBySelected() {
        return productRepository.findProductBySelected().stream()
                .map(ProductDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findListProductByPromo() {
        return productRepository.findProductByPromo().stream()
                .map(ProductDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findTop24ByOrderByCreateDateDesc() {
        return productRepository.findTop24ByOrderByCreatedDateDesc().stream()
                .map(ProductDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findByOrderByIdDesc() {
        return productRepository.findByOrderByIdDesc().stream()
                .map(ProductDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findTop3ByOrderByIdDesc() {
        return productRepository.findTop3ByOrderByIdDesc().stream()
                .map(ProductDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findTop4ByOrderByIdDesc() {
        return productRepository.findTop4ByOrderByIdDesc().stream()
                .map(ProductDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findTop8ByOrderByIdDesc() {
        return productRepository.findTop8ByOrderByIdDesc().stream()
                .map(ProductDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findListProductByPriceMinMax(double min, double max) {
        return productRepository.findListProductByPriceMinMax(min, max).stream()
                .map(ProductDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductDto> findProductByPageable(Pageable pageable) {
        return productRepository.findProductByPageable(pageable)
                .map(ProductDto::fromEntityToDto);
    }

    @Override
    public Page<ProductDto> findProductBySubCategoryPageable(Long scatId, Pageable pageable) {
        return productRepository.findBySubcategory(scatId, pageable)
                .map(ProductDto::fromEntityToDto);
    }

    @Override
    public Page<ProductDto> findProductBySamePricePageable(double price, Pageable pageable) {
        return productRepository.findProductPageableGroupByPrice(price, pageable)
                .map(ProductDto::fromEntityToDto);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Product not found");
            return;
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> findProductByPageable(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable)
                .map(ProductDto::fromEntityToDto).getContent();
    }

    @Override
    public List<ProductDto> findProductByKeywordByPageable(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByDesignationContaining(keyword, pageable)
                .map(ProductDto::fromEntityToDto).getContent();
    }

    @Override
    public List<ProductDto> findProductsBySubCategoryId(Long scatId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findProductBySubcategoryByPageable(scatId, pageable)
                .map(ProductDto::fromEntityToDto).getContent();
    }

    @Override
    public long getProductsByCategoryIdLength(Long id) {
        return productRepository.getOrderLengthBySubcategoryId(id);
    }

    @Override
    public long getProductSizeByKey(String key) {
        return productRepository.getOrderSizeByKey(key);
    }

    @Override
    public long getAllProductsSize() {
        return productRepository.count();
    }


}
