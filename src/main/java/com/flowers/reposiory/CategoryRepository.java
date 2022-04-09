package com.flowers.reposiory;

import com.flowers.models.Address;
import com.flowers.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByOrderByIdDesc();

}
