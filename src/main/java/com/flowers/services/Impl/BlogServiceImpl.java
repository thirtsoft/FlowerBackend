package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Blog;
import com.flowers.reposiory.BlogRepository;
import com.flowers.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long blogId, Blog blog) {
        if (!blogRepository.existsById(blogId)) {
            throw new ResourceNotFoundException("Blog that id is" + blogId + "is not found");
        }
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);

        if (!optionalBlog.isPresent()) {
            throw new ResourceNotFoundException("Blog not found");
        }

        Blog blogResult = optionalBlog.get();
        blogResult.setTitle(blog.getTitle());
        blogResult.setImage(blog.getImage());
        blogResult.setDescription(blog.getDescription());
        blogResult.setUtilisateur(blog.getUtilisateur());
        blogResult.setCreatedDate(new Date());

        return blogRepository.save(blogResult);
    }

    @Override
    public Optional<Blog> findBlogById(Long id) {
        if (!blogRepository.existsById(id)) {
            throw new ResourceNotFoundException("Blog that id is" + id + "is not found");
        }
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> findAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findBlogByOrderByIdDesc() {
        return blogRepository.findByOrderByIdDesc();
    }

    @Override
    public BigDecimal countNumberOfBlogs() {
        return blogRepository.countNumberOfNewsletters();
    }

    @Override
    public void deleteBlog(Long id) {
        if (!blogRepository.existsById(id)) {
            throw new ResourceNotFoundException("Blog that id is" + id + "is not found");
        }
        blogRepository.deleteById(id);
    }
}
