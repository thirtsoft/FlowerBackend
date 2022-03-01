package com.flowers.controllers;

import com.flowers.controllers.api.BlogApi;
import com.flowers.dtos.BlogDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Blog;
import com.flowers.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
public class BlogController implements BlogApi {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @Override
    public ResponseEntity<BlogDto> saveBlog(BlogDto blogDto) {
        return null;
    }

    @Override
    public ResponseEntity<BlogDto> updateBlog(Long blogId, BlogDto blogDto) {
        return null;
    }

    @Override
    public ResponseEntity<BlogDto> getBlogById(Long blogId) {
        return null;
    }

    @Override
    public ResponseEntity<List<BlogDto>> getAllBlogs() {
        return null;
    }

    @Override
    public ResponseEntity<List<BlogDto>> getAllBlogsOrderByIdDesc() {
        return null;
    }

    @Override
    public BigDecimal countNumberOfBlog() {
        return blogService.countNumberOfBlogs();
    }

    @Override
    public void deleteBlog(Long blogId) {
        blogService.deleteBlog(blogId);
    }
}
