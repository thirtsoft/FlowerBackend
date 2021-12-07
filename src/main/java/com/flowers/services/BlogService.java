package com.flowers.services;

import com.flowers.models.Blog;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BlogService {

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long blogId, Blog blog);

    Optional<Blog> findBlogById(Long id);

    List<Blog> findAllBlog();

    List<Blog> findBlogByOrderByIdDesc();

    BigDecimal countNumberOfBlogs();

    void deleteBlog(Long id);

}
