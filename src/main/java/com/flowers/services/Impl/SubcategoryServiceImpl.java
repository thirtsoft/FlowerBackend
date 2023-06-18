package com.flowers.services.Impl;

import com.flowers.dtos.SubCategoryDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Subcategory;
import com.flowers.reposiory.SubcategoryRepository;
import com.flowers.services.SubcategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class SubcategoryServiceImpl implements SubcategoryService {

    @Autowired
    private final SubcategoryRepository subcategoryRepository;

    @Override
    public SubCategoryDto saveSubcategory(SubCategoryDto subCategoryDto) {
        subCategoryDto.setActif(true);
        return SubCategoryDto.fromEntityToDto(
                subcategoryRepository.save(
                        SubCategoryDto.fromDtoToEntity(subCategoryDto))
        );
    }

    @Override
    public SubCategoryDto updateSubcategory(Long subCatId, SubCategoryDto subCategoryDto) {
        if (!subcategoryRepository.existsById(subCatId)) {
            throw new ResourceNotFoundException("SubCategory not found");
        }

        Optional<Subcategory> optionalSubcategory = subcategoryRepository.findById(subCatId);

        if (!optionalSubcategory.isPresent()) {
            throw new ResourceNotFoundException("SubCategory not found");
        }

        SubCategoryDto subCategoryDtoResult = SubCategoryDto.fromEntityToDto(optionalSubcategory.get());

        subCategoryDtoResult.setSubCategoryName(subCategoryDto.getSubCategoryName());
        subCategoryDtoResult.setDescription(subCategoryDto.getDescription());
        subCategoryDtoResult.setCategoryDto(subCategoryDto.getCategoryDto());

        return SubCategoryDto.fromEntityToDto(
                subcategoryRepository.save(
                        SubCategoryDto.fromDtoToEntity(subCategoryDtoResult)
                )
        );

    }

    @Override
    public SubCategoryDto findSubcategoryById(Long subCatId) {
        if (subCatId == null) {
            log.error("SubCategory Id is null");
            return null;
        }

        Optional<Subcategory> optionalSubcategory = subcategoryRepository.findById(subCatId);

        return Optional.of(SubCategoryDto.fromEntityToDto(optionalSubcategory.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun SubCategory avec l'Id = " + subCatId + "n'a été trouvé")
        );
    }

    @Override
    public List<SubCategoryDto> findAllSubcategories() {
        return subcategoryRepository.findAll().stream()
                .map(SubCategoryDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubCategoryDto> findSubcategoryByCategoryId(Long catId) {
        return subcategoryRepository.findSubcategoryByCategoryId(catId).stream()
                .map(SubCategoryDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubCategoryDto> findSubcategoryByOrderByIdDesc() {
        return subcategoryRepository.findByOrderByIdDesc().stream()
                .map(SubCategoryDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long subCatId) {
        if (subCatId == null) {
            log.error("Subcategory not found");
            return;
        }
        subcategoryRepository.deleteById(subCatId);
    }

    @Override
    public List<SubCategoryDto> findAllActiveSubCategories() {
        return subcategoryRepository.findAll().stream()
                .map(SubCategoryDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSubcategory(Long subCatId) {
        if (subCatId == null) {
            log.error("Subcategory not found");
            return;
        }
        Subcategory subcategory = subcategoryRepository.findById(subCatId).get();
        subcategory.setActif(false);
        subcategoryRepository.save(subcategory);
    }
}
