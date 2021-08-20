package com.flowers.controllers.api;

import com.flowers.models.Category;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;


public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/categories/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Category> saveCategory(@RequestBody Category category);

    @PutMapping(value = APP_ROOT + "/categories/update/{catId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Category> updateCategory(@PathVariable(value = "catId") Long catId, @RequestBody Category category);

    @GetMapping(value = APP_ROOT + "/categories/{catId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Category> findCategoryById(@PathVariable(value = "catId") Long catId);

    @GetMapping(value = APP_ROOT + "/categories/searchCategoryByCode", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Category> findByCode(@RequestParam(name = "code") String code);

    @GetMapping(value = APP_ROOT + "/categories/searchCategoryByDesignation", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Category> findByDesignation(@RequestParam(name = "designation") String designation);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
   /* @ApiOperation(value = "Renvoi la liste des approvisonnement",
            notes = "Cette méthode permet de chercher et renvoyer la liste des approvisionnements", responseContainer = "List<Approvisionnement>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des approvisionnements / une liste vide")
    })*/
    ResponseEntity<List<Category>> getAllCategories();

    @GetMapping(value = APP_ROOT + "/categories/searchListCategoriesByCode", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Category>> getListCategoriesByCode(@RequestParam(name = "code") String code);

    @GetMapping(value = APP_ROOT + "/categories/searchListCategoriesByDesignation", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Category>> getListCategoriesByDesignation(@RequestParam(name = "designation") String designation);

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{catId}")
    void deleteCategory(@PathVariable(name = "catId") Long catId);

}
