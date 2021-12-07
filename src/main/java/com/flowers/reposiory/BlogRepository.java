package com.flowers.reposiory;

import com.flowers.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query("select count(p) from Blog p ")
    BigDecimal countNumberOfNewsletters();

    List<Blog> findByOrderByIdDesc();
}
