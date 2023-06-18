package com.flowers.services.Impl;

import com.flowers.dtos.BlogDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Blog;
import com.flowers.reposiory.BlogRepository;
import com.flowers.services.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public BlogDto saveBlog(BlogDto blogDto) {
        blogDto.setActif(true);
        return BlogDto.fromEntityToDto(
                blogRepository.save(
                        BlogDto.fromDtoToEntity(blogDto)
                )
        );
    }

    @Override
    public BlogDto updateBlog(Long blogId, BlogDto blogDto) {
        if (!blogRepository.existsById(blogId)) {
            throw new ResourceNotFoundException("Blog not found");
        }

        Optional<Blog> optionalBlog = blogRepository.findById(blogId);

        if (!optionalBlog.isPresent()) {
            throw new ResourceNotFoundException("Blog not found");
        }

        BlogDto blogDtoResult = BlogDto.fromEntityToDto(optionalBlog.get());
        blogDtoResult.setTitle(blogDto.getTitle());
        blogDtoResult.setImage(blogDto.getImage());
        blogDtoResult.setDescription(blogDto.getDescription());
        blogDtoResult.setCreateDate(blogDto.getCreateDate());
        blogDtoResult.setUtilisateurDto(blogDto.getUtilisateurDto());


        return BlogDto.fromEntityToDto(
                blogRepository.save(
                        BlogDto.fromDtoToEntity(blogDtoResult)
                )
        );

    }

    @Override
    public BlogDto findBlogById(Long id) {
        if (id == null) {
            log.error("Article Id is null");
            return null;
        }
        Optional<Blog> optionalBlog = blogRepository.findById(id);

        return Optional.of(BlogDto.fromEntityToDto(optionalBlog.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun Blog avec l'Id = " + id + "n'a été trouvé")
        );
    }

    @Override
    public List<BlogDto> findAllBlog() {
        return blogRepository.findAll().stream()
                .map(BlogDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BlogDto> findBlogByOrderByIdDesc() {
        return blogRepository.findByOrderByIdDesc().stream()
                .map(BlogDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal countNumberOfBlogs() {
        return null;
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Blog Id is null");
            return;
        }
        blogRepository.deleteById(id);
    }

    @Override
    public List<BlogDto> findAllActiveBlogs() {
        return blogRepository.findAll().stream()
                .map(BlogDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBlog(Long id) {
        if (id == null) {
            log.error("Blog Id is null");
            return;
        }
        Blog blog = blogRepository.findById(id).get();
        blog.setActif(false);
        blogRepository.save(blog);
    }
}

