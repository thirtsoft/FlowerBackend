package com.flowers.controllers.api;

import com.flowers.dtos.BlogDto;
import com.flowers.exceptions.ResourceNotFoundException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface BlogApi {

    @PostMapping(value = APP_ROOT + "/blogs/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Blog",
            notes = "Cette méthode permet d'ajouter une Blog", response = BlogDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Blog a été crée"),
            @ApiResponse(code = 400, message = "Aucun Blog  crée / modifié")
    })
    ResponseEntity<BlogDto> saveBlog(@RequestBody BlogDto blogDto);

    @PutMapping(value = APP_ROOT + "/blogs/update/{blogId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Blog par son ID",
            notes = "Cette méthode permet de modifier une Blog par son ID", response = BlogDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Blog a été modifiée"),
            @ApiResponse(code = 400, message = "La Blog a n'est pas modifiée")
    })
    ResponseEntity<BlogDto> updateBlog(@PathVariable(value = "blogId") Long blogId, @RequestBody BlogDto blogDto);

    @GetMapping(value = APP_ROOT + "/blogs/findById/{blogId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Blog par ID",
            notes = "Cette méthode permet de chercher une Blog par son ID", response = BlogDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Blog a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Blog n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<BlogDto> getBlogById(@PathVariable(value = "blogId") Long blogId);


    @GetMapping(value = APP_ROOT + "/blogs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des blogs",
            notes = "Cette méthode permet de chercher et renvoyer la liste des blogs", responseContainer = "List<BlogDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des blogs / une liste vide")
    })
    ResponseEntity<List<BlogDto>> getAllBlogs();

    @GetMapping(value = APP_ROOT + "/blogs/searchAllBlogsOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Blog par ordre descroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Blog par ordre descroissante",
            responseContainer = "List<BlogDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Newsletter  par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<BlogDto>> getAllBlogsOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/blogs/countNumberOfBlog", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Blog",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Blog")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Blog / le nombre est nulle")
    })
    BigDecimal countNumberOfBlog();

    @DeleteMapping(value = APP_ROOT + "/blogs/delete/{blogId}")
    @ApiOperation(value = "Supprimer un Blog par son ID",
            notes = "Cette méthode permet de supprimer une Blog par son ID", response = BlogDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Blog a été supprimé")
    })
    void deleteBlog(@PathVariable(name = "blogId") Long blogId);
}
