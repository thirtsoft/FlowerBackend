package com.flowers;

import com.flowers.enums.RoleName;
import com.flowers.models.*;
import com.flowers.reposiory.*;
import com.flowers.services.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class FlowerBackendApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(FlowerBackendApplication.class);

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private SubcategoryRepository subcategoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private FournisseurRepository fournisseurRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private WishlistRepository wishlistRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	PasswordEncoder encoder;



	public static void main(String[] args) {
		SpringApplication.run(FlowerBackendApplication.class, args);
		createDirectoryIfItDoesntExist();
	}


	private static void createDirectoryIfItDoesntExist() {
		Path path = Paths.get(System.getProperty("user.home") + "/flowers/photos/");

		if (Files.notExists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException ie) {
				LOG.error(String.format("Problem creating directory %s", path));
			}
		}
	}

	@Override
	public void run(String... args) throws Exception {

		Category c1 = categoryRepository.save(new Category(1L, "SIDE TABLE", "cat1"));
		Category c2 = categoryRepository.save(new Category(2L, "FIREPLACE", "cat2"));
		Category c3 = categoryRepository.save(new Category(3L, "TABLE LAMP", "cat3"));
		Category c4 = categoryRepository.save(new Category(4L, "OTTOMAN", "cat4"));
		Category c5 = categoryRepository.save(new Category(5L, "ARMCHAIR", "cat5"));
		Category c6 = categoryRepository.save(new Category(6L, "CUSHION", "cat6"));
		Category c7 = categoryRepository.save(new Category(7L, "COFFEE TABLE", "cat7"));
		Category c8 = categoryRepository.save(new Category(8L, "SHELF", "cat8"));
		Category c9 = categoryRepository.save(new Category(9L, "SOFA", "cat9"));
		Category c10 = categoryRepository.save(new Category(10L, "DRESSING TABLE", "cat10"));
		Category c11 = categoryRepository.save(new Category(11L, "WINDOWN CURTAIN", "cat11"));
		Category c12 = categoryRepository.save(new Category(12L, "CHANDELIER", "cat12"));
		Category c13 = categoryRepository.save(new Category(13L, "CEILING FAN", "cat13"));

		Subcategory sc1 = subcategoryRepository.save(new Subcategory(1L, "Aliquam lobortis", "Fashion & Beauty", c1));
		Subcategory sc2 = subcategoryRepository.save(new Subcategory(2L, "Duis Reprehenderit", "Fashion & Beauty", c1));
		Subcategory sc3 = subcategoryRepository.save(new Subcategory(3L, "Voluptate", "Fashion & Beauty", c1));
		Subcategory sc4 = subcategoryRepository.save(new Subcategory(4L, "Tongue Est", "Fashion & Beauty", c1));
		Subcategory sc5 = subcategoryRepository.save(new Subcategory(5L, "Venison Andouille", "Fashion & Beauty", c1));
		Subcategory sc6 = subcategoryRepository.save(new Subcategory(6L, "Aliquam lobortis", "Fashion & Beauty", c2));
		Subcategory sc7 = subcategoryRepository.save(new Subcategory(7L, "Duis Reprehenderit", "Fashion & Beauty", c2));
		Subcategory sc8 = subcategoryRepository.save(new Subcategory(8L, "Voluptate", "Fashion & Beauty", c2));
		Subcategory sc9 = subcategoryRepository.save(new Subcategory(9L, "Tongue Est", "Fashion & Beauty", c2));
		Subcategory sc10 = subcategoryRepository.save(new Subcategory(10L, "Venison Andouille", "Fashion & Beauty", c2));
		Subcategory sc11 = subcategoryRepository.save(new Subcategory(11L, "Aliquam lobortis", "Fashion & Beauty", c3));
		Subcategory sc12 = subcategoryRepository.save(new Subcategory(12L, "Duis Reprehenderit", "Fashion & Beauty", c3));
		Subcategory sc13 = subcategoryRepository.save(new Subcategory(13L, "Voluptate", "Fashion & Beauty", c3));
		Subcategory sc14 = subcategoryRepository.save(new Subcategory(14L, "Tongue Est", "Fashion & Beauty", c3));

		Subcategory sc15 = subcategoryRepository.save(new Subcategory(15L, "Voluptate", "Fashion & Beauty", c4));
		Subcategory sc16 = subcategoryRepository.save(new Subcategory(16L, "Voluptate", "Fashion & Beauty", c5));
		Subcategory sc17 = subcategoryRepository.save(new Subcategory(17L, "Voluptate", "Fashion & Beauty", c6));
		Subcategory sc18 = subcategoryRepository.save(new Subcategory(18L, "Voluptate", "Fashion & Beauty", c7));
		Subcategory sc19 = subcategoryRepository.save(new Subcategory(19L, "Voluptate", "Fashion & Beauty", c8));



		Product p1 = productRepository.save(new Product(1L, "prod1", "Nulla et justo non augue", 1700.0, 1600.0, 150, "1.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc1));
		Product p2 = productRepository.save(new Product(2L, "prod2", "Nulla et justo non augue", 1700.0, 1500.0, 150, "22.jpg",false, true, true, "prod1prod1prod1", "prod1prod1prod1", sc2));
		Product p3 = productRepository.save(new Product(3L, "prod3", "Lave Linge Original", 1700.0, 1400.0, 150, "2.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc3));
		Product p4 = productRepository.save(new Product(4L, "prod4", "Ecouteur Montage vidéos", 1700.0, 1300.0, 150, "11.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc4));
		Product p5 = productRepository.save(new Product(5L, "prod5", "Lave Linges marque USA", 1700.0,1200.0, 150, "3.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc5));
		Product p6 = productRepository.save(new Product(6L, "prod6", "Lot de Machine à café ", 1700.0, 1100.0, 150, "14.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc6));
		Product p7 = productRepository.save(new Product(7L, "prod7", "Frigo Samsung Blanc", 1700.0, 1000.0, 150, "5.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc7));
		Product p8 = productRepository.save(new Product(8L, "prod8", "Lacoste Eté Classe", 1700.0, 900.0, 150, "11.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc8));
		Product p9 = productRepository.save(new Product(9L, "prod9", "Tablettes Samsung Galaxie", 1700.0, 800.0, 150, "8.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc9));
		Product p10 = productRepository.save(new Product(10L, "prod10", "Robe Ete", 1700.0,700.0, 150, "14.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc10));
		Product p11 = productRepository.save(new Product(11L, "prod11", "HuperCool", 1700.0,600.0, 150, "11.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc11));
		Product p12 = productRepository.save(new Product(12L, "prod12", "Parfums", 1700.0,500.0, 150, "12.jpg",false, true, true, "prod1prod1prod1","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc12));
		Product p13 = productRepository.save(new Product(13L, "prod13", "Eaux de Cologne", 1700.0, 400.0, 150, "13.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc13));
		Product p14 = productRepository.save(new Product(14L, "prod14", "Ordinateurs", 1700.0, 300.0, 150, "23.jpg",false, true, true, "prod1prod1prod1","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc1));
		Product p15 = productRepository.save(new Product(15L, "prod15", "Mini PC", 1700.0, 1600.0, 150, "26.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc1));
		Product p16 = productRepository.save(new Product(16L, "prod16", "Fleur-16", 1700.0, 1500.0, 150, "11.jpg",false, true, true, "prod1prod1prod1", "prod1prod1prod1", sc3));
		Product p17 = productRepository.save(new Product(17L, "prod17", "Fleurs-17", 1700.0, 1400.0, 150, "17.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc1));
		Product p18 = productRepository.save(new Product(18L, "prod18", "Fleur-18", 1700.0, 1600.0, 150, "20.jpg",false, true, true, "prod1prod1prod1", "prod1prod1prod1", sc5));
		Product p19 = productRepository.save(new Product(19L, "prod19", "Fleur-19", 1700.0, 1300.0, 150, "28.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc1));
		Product p20 = productRepository.save(new Product(20L, "prod20", "Fleur-20", 1700.0, 1200.0, 150, "34.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc1));


		Fournisseur f1 = fournisseurRepository.save(new Fournisseur(1L, "f1", "f1", "f1", "f1", "f1", "f1", p1));
		Fournisseur f2 = fournisseurRepository.save(new Fournisseur(2L, "f2", "f2", "f2", "f2", "f2", "f2", p2));
		Fournisseur f3 = fournisseurRepository.save(new Fournisseur(3L, "f3", "f3", "f3", "f3", "f3", "f3", p3));
		Fournisseur f4 = fournisseurRepository.save(new Fournisseur(4L, "f4", "f4", "f4", "f4", "f4", "f4", p4));

		Country count1 = countryRepository.save(new Country(1L, "SEN", "SENEGAL"));
		Country count2 = countryRepository.save(new Country(2L, "USA", "Etats-Unies"));
		Country count3 = countryRepository.save(new Country(3L, "GUIN", "Guinnée-Conakry"));
		Country count4 = countryRepository.save(new Country(4L, "JAP", "Japon"));
		Country count5 = countryRepository.save(new Country(5L, "GB", "Gambie"));
		Country count6 = countryRepository.save(new Country(6L, "CH", "Chine"));
		Country count7 = countryRepository.save(new Country(7L, "AR", "Arabie-Souadite"));
		Country count8 = countryRepository.save(new Country(8L, "FR", "France"));
		Country count9 = countryRepository.save(new Country(9L, "NG", "Nigeria"));
		Country count10 = countryRepository.save(new Country(10L, "Ind", "Inde"));

		State state1 = stateRepository.save(new State(1L, "Dakar", count1));
		State state2 = stateRepository.save(new State(2L, "Ziguinchor", count1));
		State state3 = stateRepository.save(new State(3L, "Thies", count1));
		State state4 = stateRepository.save(new State(4L, "Fatick", count1));
		State state5 = stateRepository.save(new State(5L, "California", count2));
		State state6 = stateRepository.save(new State(6L, "Japon", count4));
		State state7 = stateRepository.save(new State(7L, "Labe", count3));
		State state8 = stateRepository.save(new State(8L, "Chine", count6));
		State state9 = stateRepository.save(new State(9L, "Dalaba", count3));
		State state10 = stateRepository.save(new State(10L, "Accra", count9));
		

		Role useRole = roleRepository.save(new Role(RoleName.ROLE_USER));
		Role managerRole = roleRepository.save(new Role(RoleName.ROLE_MANAGER));
		Role adminRole = roleRepository.save(new Role(RoleName.ROLE_ADMIN));

		Utilisateur admin = new Utilisateur();
		admin.setId(3L);
		admin.setUsername("Admin");
		admin.setName("Admin");
		admin.setPassword(encoder.encode("admin1234"));
		utilisateurRepository.save(admin);

		utilisateurService.addRoleToUser("Admin", RoleName.ROLE_ADMIN);


	}


}
