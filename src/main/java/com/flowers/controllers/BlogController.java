package com.flowers.controllers;

import com.flowers.controllers.api.BlogApi;
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
    public ResponseEntity<Blog> saveBlog(Blog blog) {
        return ResponseEntity.ok(blogService.saveBlog(blog));
    }

    @Override
    public ResponseEntity<Blog> updateBlog(Long blogId, Blog blog) {
        blog.setId(blogId);
        return ResponseEntity.ok(blogService.saveBlog(blog));
    }

    @Override
    public ResponseEntity<Blog> getBlogById(Long blogId) throws ResourceNotFoundException {
        Blog blog = blogService.findBlogById(blogId)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
        return ResponseEntity.ok().body(blog);
    }

    @Override
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogList = blogService.findAllBlog();
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Blog>> getAllBlogsOrderByIdDesc() {
        List<Blog> blogList = blogService.findBlogByOrderByIdDesc();
        return new ResponseEntity<>(blogList, HttpStatus.OK);
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
