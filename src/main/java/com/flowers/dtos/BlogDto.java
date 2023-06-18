package com.flowers.dtos;

import com.flowers.models.Blog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {

    private Long id;

    @NotNull
    private String title;

    private String image;

    @NotNull
    private String description;

    private Date createDate;

    private UtilisateurDto utilisateurDto;

    private int actif;

    public void setActif(boolean actif) {
        if (actif == true)
            this.actif = 1;
        else
            this.actif = 0;
    }

    public boolean isActif() {
        if (actif == 1)
            return true;
        else
            return false;
    }

    public static BlogDto fromEntityToDto(Blog blog) {
        if (blog == null) {
            return null;
        }

        return BlogDto.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .image(blog.getImage())
                .description(blog.getDescription())
                .createDate(blog.getCreatedDate())
                .actif(blog.getActif())
                .utilisateurDto(UtilisateurDto.fromEntityToDto(blog.getUtilisateur()))
                .build();
    }

    public static Blog fromDtoToEntity(BlogDto blogDto) {
        if (blogDto == null) {
            return null;
        }

        Blog blog = new Blog();
        blog.setTitle(blogDto.title);
        blog.setImage(blogDto.getImage());
        blog.setDescription(blogDto.getDescription());
        blog.setCreatedDate(blogDto.getCreateDate());
        blog.setActif(blogDto.isActif());
        blog.setUtilisateur(UtilisateurDto.fromDtoToEntity(blogDto.getUtilisateurDto()));
        return blog;
    }
}
