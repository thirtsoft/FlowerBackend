package com.flowers.controllers;

import com.flowers.controllers.api.BlogApi;
import com.flowers.dtos.AddressDto;
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

@CrossOrigin(origins = "https://fleurpourtous.com")
@RestController
public class BlogController implements BlogApi {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @Override
    public ResponseEntity<BlogDto> saveBlog(BlogDto blogDto) {
        BlogDto blogDtoResult = blogService.saveBlog(blogDto);
        return new ResponseEntity<>(blogDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BlogDto> updateBlog(Long blogId, BlogDto blogDto) {
        blogDto.setId(blogId);
        BlogDto blogDtoResult = blogService.saveBlog(blogDto);
        return new ResponseEntity<>(blogDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BlogDto> getBlogById(Long blogId) {
        BlogDto blogDtoResult = blogService.findBlogById(blogId);
        return new ResponseEntity<>(blogDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BlogDto>> getAllBlogs() {
        List<BlogDto> blogDtoList = blogService.findAllBlog();
        return new ResponseEntity<>(blogDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BlogDto>> getAllBlogsOrderByIdDesc() {
        List<BlogDto> blogDtoList = blogService.findBlogByOrderByIdDesc();
        return new ResponseEntity<>(blogDtoList, HttpStatus.OK);
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
