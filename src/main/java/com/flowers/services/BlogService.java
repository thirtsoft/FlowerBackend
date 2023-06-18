package com.flowers.services;

import com.flowers.dtos.AddressDto;
import com.flowers.dtos.BlogDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BlogService {

    BlogDto saveBlog(BlogDto blogDto);

    BlogDto updateBlog(Long blogId, BlogDto blogDto);

    BlogDto findBlogById(Long id);

    List<BlogDto> findAllBlog();

    List<BlogDto> findBlogByOrderByIdDesc();

    BigDecimal countNumberOfBlogs();

    void delete(Long id);

    List<BlogDto> findAllActiveBlogs();

    void deleteBlog(Long blogId);

}
