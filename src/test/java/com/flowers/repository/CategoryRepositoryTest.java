package com.flowers.repository;

import com.flowers.models.Category;
import com.flowers.reposiory.CategoryRepository;
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
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_category_Test() {
        Category category = new Category();
        category.setId(1L);
        category.setCategoryName("Fleur Mariage");
        category.setDescription("Categories categories");
        categoryRepository.save(category);

        assertThat(category.getId()).isGreaterThan(0);
        assertThat(category.getCategoryName()).isNotNull();
        assertThat(category.getDescription()).isEqualTo("Categories categories");
    }

    @Test
    @Order(2)
    public void get_and_return_on_Category_by_Id_Test() {
        Category category = new Category();
        category.setId(1L);
        category.setCategoryName("Fleur Mariage");
        category.setDescription("Categories categories");
        categoryRepository.save(category);

        Category optionalCategory = categoryRepository.findById(1L).get();

        assertThat(optionalCategory.getId()).isEqualTo(category.getId());
        assertThat(optionalCategory.getCategoryName()).isEqualTo(category.getCategoryName());
        assertThat(optionalCategory.getDescription()).isEqualTo("Categories categories");
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void update_category_by_id_Test() {
        Optional<Category> optionalCategory = categoryRepository.findById(1L);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setCategoryName("Materiel");

            Category categoryUpdated = categoryRepository.save(category);
            assertThat(categoryUpdated.getId()).isEqualTo(category.getId());
            assertThat(categoryUpdated.getCategoryName()).isEqualTo("Materiel");
        }
    }

    @Test
    @Order(4)
    public void should_and_return_all_Categories_Test() {
        Category category = new Category();
        category.setId(1L);
        category.setCategoryName("Fleur Mariage");
        category.setDescription("Categories categories");
        categoryRepository.save(category);

        List<Category> categoryList = categoryRepository.findAll();

        assertThat(categoryList.size()).isNotNull();
        assertThat(categoryList.size()).isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void should_and_return_all_categories_by_IdDesc_Test() {
        Category category = new Category();
        category.setId(1L);
        category.setCategoryName("Fleur Mariage");
        category.setDescription("Categories categories");
        categoryRepository.save(category);

        List<Category> categoryList = categoryRepository.findByOrderByIdDesc();

        assertThat(categoryList.size()).isNotNull();
        assertThat(categoryList.size()).isGreaterThan(0);
    }

    @Test
    @Order(6)
    @Rollback(value = false)
    public void delete_category_by_id_Test() {
        Optional<Category> optionalCategory = categoryRepository.findById(1L);
        if (optionalCategory.isPresent()) {
            categoryRepository.delete(optionalCategory.get());
        }
        Category category = null;
        Optional<Category> optionalCategory01 = categoryRepository.findById(1L);
        if (optionalCategory01.isPresent()) {
            category = optionalCategory01.get();
        }
        assertThat(category).isNull();
    }


}
