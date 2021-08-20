package com.flowers.controllers.api;

import com.flowers.models.Product;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface ProductApi {

    @PostMapping(value = APP_ROOT + "/products/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Artilce",
            notes = "Cette méthode permet d'ajouter un Product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "L'Artilce a été crée"),
            @ApiResponse(code = 400, message = "Aucun Artilce  crée / modifié")

    })
    ResponseEntity<Product> save(@RequestBody Product product);

    @PostMapping(value = APP_ROOT + "/products/createWithFile")
    @ApiOperation(value = "Enregistrer un Artilce avec une photo",
            notes = "Cette méthode permet d'ajouter un Product une photo", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "L'Artilce a été crée"),
            @ApiResponse(code = 400, message = "Aucun Artilce  crée / modifié")

    })
    ResponseEntity<Product> saveProductWithFile(@RequestParam(name = "Product") String product,
                                                @RequestParam(name = "photoProduct") MultipartFile photoProduct) throws IOException;

    @PutMapping(value = APP_ROOT + "/products/update/{idProduct}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier un Product par son ID",
            notes = "Cette méthode permet de modifier un Product par son ID", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Artilce a été modifiée"),
            @ApiResponse(code = 400, message = "L'Artilce a n'est pas modifiée")
    })
    ResponseEntity<Product> update(@PathVariable("idProduct") Long id, @RequestBody Product product);

    @GetMapping(value = APP_ROOT + "/products/{idProduct}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Artilce par ID",
            notes = "Cette méthode permet de chercher un Artilce par son ID", response = Product.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Artilce a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Artilce n'existe avec cette ID pas dans la BD")

    })
    ResponseEntity<Product> findById(@PathVariable("idProduct") Long id);

    @GetMapping(value = APP_ROOT + "/products/searchProductbyReference/{reference}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un Artilce par Reference",
            notes = "Cette méthode permet de chercher une Scategory par son Reference", response = Product.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Artilce a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Artilce n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<Product> findByReference(@PathVariable("reference") String reference);

    @GetMapping(value = APP_ROOT + "/products/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products", responseContainer = "List<Product>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products / une liste vide")
    })
    List<Product> findAll();

    @GetMapping(value = APP_ROOT + "/products/productsByScategories/{subCatId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par Scategory",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products par Scategory", responseContainer = "List<Product>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par Scategory / une liste vide")
    })
    List<Product> findListProductByScategories(@PathVariable("subCatId") Long subCatId);

    @GetMapping(value = APP_ROOT + "/products/searchProductByKeyword", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par mot Clé",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products par mot Clé", responseContainer = "List<Product>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par Scategory / une liste vide")
    })
    List<Product> getListProductByKeyword(@RequestParam(name = "keyword") String keyword);

    @GetMapping(value = APP_ROOT + "/products/searchProductByPrice/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par price",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products par price", responseContainer = "List<Product>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par price / une liste vide")
    })
    List<Product> getListProductByPrice(@PathVariable("price") double price);

    @GetMapping(value = APP_ROOT + "/products/searchProductByselectedIsTrue", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products selectionner",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products selectionner", responseContainer = "List<Product>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products selectionner / une liste vide")
    })
    List<Product> getListProductBySelected();

    @GetMapping(value = APP_ROOT + "/products/searchProductByPageables", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par pages",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products par pages", responseContainer = "Page<Product>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par pages / une liste vide")
    })
    Page<Product> getListProductByPageable(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size);

    @GetMapping(value = APP_ROOT + "/products/searchProductByScategoryByPageables", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par Scategory",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products par Scategory par pages", responseContainer = "Page<Product>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par Scategory par pages / une liste vide")
    })
    Page<Product> getListProductByScategoryByPageable(@RequestParam("id") Long scatId, @RequestParam(name = "page") int page,
                                                      @RequestParam(name = "size") int size);
    @GetMapping(value = APP_ROOT + "/products/searchProductBySamePriceByPageables", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par price",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products qui ont le meme price par pages", responseContainer = "Page<Product>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par price par pages / une liste vide")
    })
    Page<Product> getListProductBySamePriceyByPageable(@RequestParam("price") double price, @RequestParam(name = "page") int page,
                                                       @RequestParam(name = "size") int size);
    @DeleteMapping(value = APP_ROOT + "/products/delete/{idProduct}")
    @ApiOperation(value = "Supprimer un Product par son ID",
            notes = "Cette méthode permet de supprimer une Product par son ID", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Product a été supprimé")
    })
    void delete(@PathVariable("idProduct") Long id);

    @GetMapping(value = APP_ROOT + "/products/photoProduct/{idProduct}")
    @ApiOperation(value = "Recupérer une photo par ID",
            notes = "Cette méthode permet de récupérer la photo d'un Product par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La photo est affiché")
    })
    byte[] getPhotoProduct(@PathVariable("idProduct") Long id) throws Exception;

    @PostMapping(path = APP_ROOT + "/products/uploadProductPhoto/{idProduct}")
    @ApiOperation(value = "Enregistrer une photo dans un dossier",
            notes = "Cette méthode permet d'enregistrer la photo d'un Product dans un dossier externe utilisateur")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La photo a été enregistré dans le dossier utilisateur")

    })
    void uploadPhotoProduct(@RequestParam(name = "photoProduct") MultipartFile photoProduct,
                            @PathVariable("idProduct") Long idProduct) throws IOException;
}
