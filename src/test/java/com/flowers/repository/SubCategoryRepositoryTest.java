package com.flowers.repository;

import com.flowers.models.Category;
import com.flowers.models.Subcategory;
import com.flowers.reposiory.CategoryRepository;
import com.flowers.reposiory.SubcategoryRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SubCategoryRepositoryTest {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_subcategory_Test() {
        Category category = new Category();
        category.setCategoryName("Fleur Mariage");
        category.setDescription("Categories categories");
        categoryRepository.save(category);
        Subcategory subcategory = new Subcategory();
        subcategory.setId(1L);
        subcategory.setSubCategoryName("Fleur01");
        subcategory.setCategory(category);
        subcategoryRepository.save(subcategory);

        assertThat(subcategory.getId()).isGreaterThan(0);
        assertThat(subcategory.getSubCategoryName()).isNotNull();
        assertThat(subcategory.getCategory()).isEqualTo(category);
    }

    @Test
    @Order(2)
    public void get_and_return_on_subcategory_by_Id_Test() {
        Category category = new Category();
        category.setCategoryName("Fleur");
        category.setDescription("Categories");
        categoryRepository.save(category);
        Subcategory subcategory = new Subcategory();
        subcategory.setId(2L);
        subcategory.setSubCategoryName("Fleur01");
        subcategory.setCategory(category);
        subcategoryRepository.save(subcategory);

        Subcategory optionalSubCategory = subcategoryRepository.findById(subcategory.getId()).get();

        assertThat(optionalSubCategory.getId()).isEqualTo(subcategory.getId());
        assertThat(optionalSubCategory.getSubCategoryName()).isEqualTo(subcategory.getSubCategoryName());
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void update_subcategory_by_id_Test() {
        Optional<Subcategory> optionalSubCategory = subcategoryRepository.findById(1L);
        if (optionalSubCategory.isPresent()) {
            Subcategory subcategory = optionalSubCategory.get();
            subcategory.setSubCategoryName("Materiel");

            Subcategory subcategoryUpdated = subcategoryRepository.save(subcategory);
            assertThat(subcategoryUpdated.getId()).isEqualTo(subcategory.getId());
            assertThat(subcategoryUpdated.getSubCategoryName()).isEqualTo("Materiel");
        }
    }

    @Test
    @Order(4)
    public void should_and_return_all_subcategories_Test() {
        Category category = new Category();
        category.setCategoryName("FleurFLEUR");
        category.setDescription("CategoriesFLeur");
        categoryRepository.save(category);
        Subcategory subcategory = new Subcategory();
        subcategory.setId(3L);
        subcategory.setSubCategoryName("Fleur01");
        subcategory.setCategory(category);
        subcategoryRepository.save(subcategory);

        List<Subcategory> subcategoryList = subcategoryRepository.findAll();

        assertThat(subcategoryList.size()).isNotNull();
        assertThat(subcategoryList.size()).isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void should_and_return_all_subcategories_by_IdDesc_Test() {
        Category category = new Category();
        category.setCategoryName("FleurFLEURFleur");
        category.setDescription("CategoriesFLeurFleur");
        categoryRepository.save(category);
        Subcategory subcategory = new Subcategory();
        subcategory.setId(3L);
        subcategory.setSubCategoryName("Fleur01");
        subcategory.setCategory(category);
        subcategoryRepository.save(subcategory);

        List<Subcategory> subcategoryList = subcategoryRepository.findByOrderByIdDesc();

        assertThat(subcategoryList.size()).isNotNull();
        assertThat(subcategoryList.size()).isGreaterThan(0);
    }

    @Test
    @Order(6)
    public void should_and_return_subcategories_by_category_id_Test() {
        Long catId = 1L;
        List<Subcategory> subcategoryList = subcategoryRepository.findSubcategoryByCategoryId(catId);

        assertThat(subcategoryList.size()).isNotNull();
        assertThat(subcategoryList.size()).isGreaterThan(0);
    }

    @Test
    @Order(7)
    @Rollback(value = false)
    public void delete_subcategory_by_id_Test() {
        Optional<Subcategory> optionalSubCategory = subcategoryRepository.findById(1L);
        if (optionalSubCategory.isPresent()) {
            subcategoryRepository.delete(optionalSubCategory.get());
        }
        Subcategory subcategory = null;
        Optional<Subcategory> optionalSubCategory01 = subcategoryRepository.findById(1L);
        if (optionalSubCategory01.isPresent()) {
            subcategory = optionalSubCategory.get();
        }
        assertThat(subcategory).isNull();
    }


}
