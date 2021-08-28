package com.flowers;

import com.flowers.models.*;
import com.flowers.reposiory.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		Category c1 = categoryRepository.save(new Category(1L, "cat1", "cat1"));
		Category c2 = categoryRepository.save(new Category(2L, "cat2", "cat2"));
		Category c3 = categoryRepository.save(new Category(3L, "cat3", "cat3"));
		Category c4 = categoryRepository.save(new Category(4L, "cat4", "cat4"));
		Category c5 = categoryRepository.save(new Category(5L, "cat5", "cat5"));
		Category c6 = categoryRepository.save(new Category(6L, "cat6", "cat6"));

		Subcategory sc1 = subcategoryRepository.save(new Subcategory(1L, "scat1", "Fashion & Beauty", c1));
		Subcategory sc2 = subcategoryRepository.save(new Subcategory(2L, "scat2", "Fashion & Beauty", c4));
		Subcategory sc3 = subcategoryRepository.save(new Subcategory(3L, "scat3", "Fashion & Beauty", c6));
		Subcategory sc4 = subcategoryRepository.save(new Subcategory(4L, "scat4", "Fashion & Beauty", c5));
		Subcategory sc5 = subcategoryRepository.save(new Subcategory(5L, "scat5", "Fashion & Beauty", c3));
		Subcategory sc6 = subcategoryRepository.save(new Subcategory(6L, "scat6", "Fashion & Beauty", c1));
		Subcategory sc7 = subcategoryRepository.save(new Subcategory(7L, "scat7", "Fashion & Beauty", c2));
		Subcategory sc8 = subcategoryRepository.save(new Subcategory(8L, "scat8", "Fashion & Beauty", c5));
		Subcategory sc9 = subcategoryRepository.save(new Subcategory(9L, "scat9", "Fashion & Beauty", c4));
		Subcategory sc10 = subcategoryRepository.save(new Subcategory(10L, "scat10", "Fashion & Beauty", c3));
		Subcategory sc11 = subcategoryRepository.save(new Subcategory(11L, "scat11", "Fashion & Beauty", c2));
		Subcategory sc12 = subcategoryRepository.save(new Subcategory(12L, "scat12", "Fashion & Beauty", c6));
		Subcategory sc13 = subcategoryRepository.save(new Subcategory(13L, "scat13", "Fashion & Beauty", c1));


		Product p1 = productRepository.save(new Product(1L, "prod1", "HP-ProBooks", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc1));
		Product p2 = productRepository.save(new Product(2L, "prod2", "Mac-Pro", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc2));
		Product p3 = productRepository.save(new Product(3L, "prod3", "Robe-Mariage", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc3));
		Product p4 = productRepository.save(new Product(4L, "prod4", "Jupe-Nuit", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc4));
		Product p5 = productRepository.save(new Product(5L, "prod5", "HP EliteBook", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc5));
		Product p6 = productRepository.save(new Product(6L, "prod6", "Mac-OS", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc6));
		Product p7 = productRepository.save(new Product(7L, "prod7", "Pantallon", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc7));
		Product p8 = productRepository.save(new Product(8L, "prod8", "Cullote", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc8));
		Product p9 = productRepository.save(new Product(9L, "prod9", "Ensembes", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc9));
		Product p10 = productRepository.save(new Product(10L, "prod10", "Robe Ete", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc10));
		Product p11 = productRepository.save(new Product(11L, "prod11", "HuperCool", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc11));
		Product p12 = productRepository.save(new Product(12L, "prod12", "Parfums", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc12));
		Product p13 = productRepository.save(new Product(13L, "prod13", "Eaux de Cologne", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc13));
		Product p14 = productRepository.save(new Product(14L, "prod14", "Ordinateurs", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc1));
		Product p15 = productRepository.save(new Product(15L, "prod15", "Mini PC", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc2));
		Product p16 = productRepository.save(new Product(16L, "prod16", "Fleur-16", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc3));
		Product p17 = productRepository.save(new Product(17L, "prod17", "Fleurs-17", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc4));
		Product p18 = productRepository.save(new Product(18L, "prod18", "Fleur-18", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc5));
		Product p19 = productRepository.save(new Product(19L, "prod19", "Fleur-19", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc6));
		Product p20 = productRepository.save(new Product(20L, "prod20", "Fleur-20", 1700.0, 150, "fleur-1.jpg",true, true, true, "prod1prod1prod1", sc7));


		Fournisseur f1 = fournisseurRepository.save(new Fournisseur(1L, "f1", "f1", "f1", "f1", "f1", "f1", p1));
		Fournisseur f2 = fournisseurRepository.save(new Fournisseur(2L, "f2", "f2", "f2", "f2", "f2", "f2", p2));
		Fournisseur f3 = fournisseurRepository.save(new Fournisseur(3L, "f3", "f3", "f3", "f3", "f3", "f3", p3));
		Fournisseur f4 = fournisseurRepository.save(new Fournisseur(4L, "f4", "f4", "f4", "f4", "f4", "f4", p4));



		Country count1 = countryRepository.save(new Country(1L, "SENEGAL"));
		Country count2 = countryRepository.save(new Country(2L, "Mali"));
		Country count3 = countryRepository.save(new Country(3L, "Japon"));
		Country count4 = countryRepository.save(new Country(4L, "Gambie"));
		Country count5 = countryRepository.save(new Country(5L, "Guinée Conakry"));
		Country count6 = countryRepository.save(new Country(6L, "Etas-Unis"));



		State state1 = new State(1L, "Dakar", count1);
		State state2 = new State(2L, "Ziguinchor", count1);
		State state3 = new State(3L, "Thies", count1);
		State state4 = new State(4L, "Fatick", count1);
		State state5 = new State(5L, "California", count2);
		State state6 = new State(6L, "Japon", count4);
		State state7 = new State(7L, "Labe", count3);
		State state8 = new State(8L, "Chine", count6);
		State state9 = new State(9L, "Dalaba", count3);
		State state10 = new State(10L, "Accra", count6);
		stateRepository.save(state1);
		stateRepository.save(state2);
		stateRepository.save(state3);
		stateRepository.save(state4);
		stateRepository.save(state5);
		stateRepository.save(state6);
		stateRepository.save(state7);
		stateRepository.save(state8);
		stateRepository.save(state9);
		stateRepository.save(state10);

		Address a1 = addressRepository.save(new Address(1L, "add1", "add1", "add1", "add1", "add1", "add1", state1));
		Address a2 = addressRepository.save(new Address(2L, "add2", "add2", "add2", "add2", "add2", "add2", state2));
		Address a3 = addressRepository.save(new Address(3L, "add3", "add3", "add3", "add3", "add3", "add3", state3));
		Address a4 = addressRepository.save(new Address(4L, "add4", "add4", "add4", "add4", "add4", "add4", state4));


	}


}
