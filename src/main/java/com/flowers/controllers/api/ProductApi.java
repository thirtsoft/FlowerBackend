package com.flowers.controllers.api;

import com.flowers.dtos.NewsletterDto;
import com.flowers.dtos.ProductDto;
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
    @ApiOperation(value = "Enregistrer un Product",
            notes = "Cette méthode permet d'ajouter un Product", response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "L'Product a été crée"),
            @ApiResponse(code = 400, message = "Aucun Product  crée / modifié")

    })
    ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto);

    @PostMapping(value = APP_ROOT + "/products/createWithFile")
    @ApiOperation(value = "Enregistrer un Product avec une photo",
            notes = "Cette méthode permet d'ajouter un Product une photo", response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "L'Product a été crée"),
            @ApiResponse(code = 400, message = "Aucun Product  crée / modifié")

    })
    ResponseEntity<ProductDto> saveProductWithFile(@RequestParam(name = "product") String product,
                                                   @RequestParam(name = "photoProduct") MultipartFile photoProduct) throws IOException;

    @PostMapping(value = APP_ROOT + "/products/createWithFilesInFolder")
    @ApiOperation(value = "Enregistrer un Product avec une photo",
            notes = "Cette méthode permet d'ajouter un Product une photo", response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Le Product a été crée"),
            @ApiResponse(code = 400, message = "Aucun Product  crée / modifié")

    })
    ResponseEntity<ProductDto> saveProductWithFilesInFolder(
            @RequestParam(name = "product") String product,
            @RequestParam(name = "photoProduct") MultipartFile photoProduct) throws IOException;

    @PutMapping(value = APP_ROOT + "/products/update/{idProduct}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier un Product par son ID",
            notes = "Cette méthode permet de modifier un Product par son ID", response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Product a été modifiée"),
            @ApiResponse(code = 400, message = "L'Product a n'est pas modifiée")
    })
    ResponseEntity<ProductDto> updateProduct(@PathVariable("idProduct") Long id, @RequestBody ProductDto productDto);

    @GetMapping(value = APP_ROOT + "/products/findById/{idProduct}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Product par ID",
            notes = "Cette méthode permet de chercher un Product par son ID", response = ProductDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Product a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Product n'existe avec cette ID pas dans la BD")

    })
    ResponseEntity<ProductDto> getProductById(@PathVariable("idProduct") Long id);

    @GetMapping(value = APP_ROOT + "/products/searchProductbyReference/{reference}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un Product par Reference",
            notes = "Cette méthode permet de chercher un Produit par sa Reference", response = ProductDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Product a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Product n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<ProductDto> getProductByReference(@PathVariable("reference") String reference);

    @GetMapping(value = APP_ROOT + "/products/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getAllProducts();

    @GetMapping(value = APP_ROOT + "/products/productsBySubCategories/{subCatId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par Scategory",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products par Scategory", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par Scategory / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getListProductBySubCategory(@PathVariable("subCatId") Long subCatId);

    @GetMapping(value = APP_ROOT + "/products/searchProductByKeyword", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par mot Clé",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products par mot Clé", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par Scategory / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getListProductByKeyword(@RequestParam(name = "keyword") String keyword);

    @GetMapping(value = APP_ROOT + "/products/searchProductByPrice/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par price",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products par price", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par price / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getListProductByPrice(@PathVariable("price") double price);

    @GetMapping(value = APP_ROOT + "/products/searchProductBySelectedIsTrue", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products Selectionner",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products selectionner", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products selectionner / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getListProductBySelected();

    @GetMapping(value = APP_ROOT + "/products/searchProductByPromoIsTrue", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products en promo",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products en promo", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products en promo / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getListProductByPromo();

    @GetMapping(value = APP_ROOT + "/products/searchTop24ProductByOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des 24 derniers produits",
            notes = "Cette méthode permet de chercher et renvoyer la liste des 24 derniers produits", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products des 24 derniers produits / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getTop24ByOrderByCreatedDateDesc();

    @GetMapping(value = APP_ROOT + "/products/searchTop3ProductByOrderIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des 3 nouveau produits",
            notes = "Cette méthode permet de chercher et renvoyer la liste des 3 derniers produits", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products des 3 derniers produits / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getTop3ByOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/products/searchTop4ProductByOrderIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des 4 nouveau produits",
            notes = "Cette méthode permet de chercher et renvoyer la liste des 4 derniers produits", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products des 4 derniers produits / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getTop4ByOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/products/searchTop8ProductByOrderIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des 8 nouveau produits",
            notes = "Cette méthode permet de chercher et renvoyer la liste des 8 derniers produits", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products des 8 derniers produits / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getTop8ByOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/products/searchAllProductOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des produits par ordre décroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des produits par ordre décroissante", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products des produit spar ordre décroissante / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getAllProductByOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/products/searchAllProductByPriceMinMax", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des produits par ordre décroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des produits par ordre décroissante", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products des produit spar ordre décroissante / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getAllProductByPriceMinMax(@RequestParam("min") double min, @RequestParam("max") double max);

    @GetMapping(value = APP_ROOT + "/products/searchProductByPageables", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par pages",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products par pages", responseContainer = "Page<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par pages / une liste vide")
    })
    Page<ProductDto> getListProductByPageable(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size);

    @GetMapping(value = APP_ROOT + "/products/searchProductBySubcategoryByPageables", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par Subcategory",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products par Scategory par pages", responseContainer = "Page<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par Subcategory par pages / une liste vide")
    })
    Page<ProductDto> getListProductBySubCategoryByPageable(@RequestParam("id") Long scatId, @RequestParam(name = "page") int page,
                                                           @RequestParam(name = "size") int size);

    @GetMapping(value = APP_ROOT + "/products/searchProductBySamePriceByPageables", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par price",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products qui ont le meme price par pages", responseContainer = "Page<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par price par pages / une liste vide")
    })
    Page<ProductDto> getListProductBySamePriceyByPageable(@RequestParam("price") double price, @RequestParam(name = "page") int page,
                                                          @RequestParam(name = "size") int size);

    @DeleteMapping(value = APP_ROOT + "/products/delete/{idProduct}")
    @ApiOperation(value = "Supprimer un Product par son ID",
            notes = "Cette méthode permet de supprimer une Product par son ID", response = ProductDto.class)
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

    @GetMapping(value = APP_ROOT + "/products/photoProductInFolder/{idProduct}")
    @ApiOperation(value = "Recupérer une photo par ID dans webapp",
            notes = "Cette méthode permet de recuperer et d'afficher la photo d'un Product depuis le dossier webapp")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La photo a été recuperer depuis le dossier webapp")

    })
    byte[] getPhotoProductInFolder(@PathVariable("idProduct") Long id) throws Exception;

    @PostMapping(path = APP_ROOT + "/products/uploadProductPhoto/{idProduct}")
    @ApiOperation(value = "Enregistrer une photo dans un dossier",
            notes = "Cette méthode permet d'enregistrer la photo d'un Product dans un dossier externe utilisateur")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La photo a été enregistré dans le dossier utilisateur")

    })
    void uploadPhotoProduct(@RequestParam(name = "photoProduct") MultipartFile photoProduct,
                            @PathVariable("idProduct") Long idProduct) throws IOException;

    @PostMapping(path = APP_ROOT + "/products/uploadProductPhotoInFolder/{id}")
    @ApiOperation(value = "Enregistrer la photo d'un produit dans webapp",
            notes = "Cette méthode permet d'enregistrer la photo d'un chauffeur dans un dossier webapp")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La photo a été enregistré dans le dossier webapp")

    })
    void uploadPhotoProductInFolder(MultipartFile file, @PathVariable("id") Long id) throws IOException;

    @GetMapping(path = APP_ROOT + "/products/countNumberTotalOfProducts")
    @ApiOperation(value = "Compter le nombre total de produits",
            notes = "Cette méthode permet de compter le nombre total de produits dans la base de donnees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de produits est")

    })
    long getNumberTotalOfProductInDatabase();

    @GetMapping(value = APP_ROOT + "/products/searchAllProductsByPageable", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des produits par pages",
            notes = "Cette méthode permet de chercher et renvoyer la liste des produits par pages", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products des produit par pages / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getAllProductsByPageable(@RequestParam int page, @RequestParam int size);

    @GetMapping(value = APP_ROOT + "/products/searchAllProductsBySubCategoryByPageable", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par sous category Id",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products par sous category Id", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par sous category Id / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getAllProductsBySuCategoryIdByPageable(@RequestParam Long id, @RequestParam int page, @RequestParam int size);

    @GetMapping(value = APP_ROOT + "/products/searchAllProductsByKeywordByPageable", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products par price",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products qui ont le meme price par pages", responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par price par pages / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getAllProductsByKeywordByPageable(@RequestParam String keyword, @RequestParam int page, @RequestParam int size);

    @GetMapping(path = APP_ROOT + "/products/productSize")
    @ApiOperation(value = "Compter la taille des produits",
            notes = "Cette méthode permet de compter la taille des produits dans la base de donnees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la taille des produits")

    })
    long getProductSizes();

    @GetMapping(path = APP_ROOT + "/products/productSizeBySubCategoryId")
    @ApiOperation(value = "Compter la total de products par sous category",
            notes = "Cette méthode permet de compter par sous category dans la base de donnees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de produits est")

    })
    long getProductSizesBySubCategoryId(@RequestParam Long id);

    @GetMapping(path = APP_ROOT + "/products/productSizeByKeyword")
    @ApiOperation(value = "Compter la taille des products par mot clé",
            notes = "Cette méthode permet de compter la dans la base de donnees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de produits est")

    })
    long getProductSizesByKeyword(@RequestParam String keyword);

    @GetMapping(value = APP_ROOT + "/products/search-all-active-products", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des products actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des products actives",
            responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des products par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<ProductDto>> getAllActiveProducts();

    @DeleteMapping(value = APP_ROOT + "/products/delete-product/{idProduct}")
    @ApiOperation(value = "Supprimer un product par son ID",
            notes = "Cette méthode permet de supprimer un product  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le product a été supprimé")
    })
    void deleteProduct(@PathVariable("idProduct") Long idProduct);

}
