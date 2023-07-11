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
   PasswordEncoder encoder;
   @Autowired
   private CategoryRepository categoryRepository;
   @Autowired
   private SubcategoryRepository subcategoryRepository;
   @Autowired
   private ProductRepository productRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    /*
    @Autowired
    private PasswordEncoder passwordEncoder;
    */
    @Autowired
    private UtilisateurService utilisateurService;



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

    /*
    @Bean
    PasswordEncoder passwordEncoder() { // NEEDED TO ALLOW PASSWORD ENCODER INSIDE SECURITY
        return new BCryptPasswordEncoder();
    }

    */
    @Override
    public void run(String... args) throws Exception {

		/*

		Product p1 = productRepository.save(new Product(1L, "prod1", "Nulla et justo non augue", 1700.0, 1600.0, 150, "product-1.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc1));
		Product p2 = productRepository.save(new Product(2L, "prod2", "Nulla et justo non augue", 1800.0, 1500.0, 150, "product-2.jpg",false, true, true, "prod1prod1prod1", "prod1prod1prod1", sc2));
		Product p3 = productRepository.save(new Product(3L, "prod3", "Lave Linge Original", 2000.0, 1400.0, 150, "product-3.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc3));
		Product p4 = productRepository.save(new Product(4L, "prod4", "Ecouteur Montage vidéos", 4000.0, 1300.0, 150, "product-4.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc4));
		Product p5 = productRepository.save(new Product(5L, "prod5", "Lave Linges marque USA", 15000.0,1200.0, 150, "product-5.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc5));
		Product p6 = productRepository.save(new Product(6L, "prod6", "Lot de Machine à café ", 10000.0, 1100.0, 150, "product-6.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc6));
		Product p7 = productRepository.save(new Product(7L, "prod7", "Frigo Samsung Blanc", 1200.0, 1000.0, 150, "product-7.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc7));
		Product p8 = productRepository.save(new Product(8L, "prod8", "Lacoste Eté Classe", 700.0, 900.0, 150, "product-8.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc8));
		Product p9 = productRepository.save(new Product(9L, "prod9", "Tablettes Samsung Galaxie", 1700.0, 800.0, 150, "8.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc9));
		Product p10 = productRepository.save(new Product(10L, "prod10", "Robe Ete", 900.0,700.0, 150, "14.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc10));
		Product p11 = productRepository.save(new Product(11L, "prod11", "HuperCool", 35000.0,600.0, 150, "11.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc11));
		Product p12 = productRepository.save(new Product(12L, "prod12", "Parfums", 12000.0,500.0, 150, "12.jpg",false, true, true, "prod1prod1prod1","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc12));
		Product p13 = productRepository.save(new Product(13L, "prod13", "Eaux de Cologne", 7000.0, 400.0, 150, "13.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc13));
		Product p14 = productRepository.save(new Product(14L, "prod14", "Ordinateurs", 1400.0, 300.0, 150, "23.jpg",false, true, true, "prod1prod1prod1","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc1));
		Product p15 = productRepository.save(new Product(15L, "prod15", "Mini PC", 28500.0, 1600.0, 150, "26.jpg",true, true, true, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
				"\n" +
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", sc1));
		Product p16 = productRepository.save(new Product(16L, "prod16", "Fleur-16", 17000.0, 1500.0, 150, "11.jpg",false, true, true, "prod1prod1prod1", "prod1prod1prod1", sc3));
		Product p17 = productRepository.save(new Product(17L, "prod17", "Fleurs-17", 500.0, 1400.0, 150, "17.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc1));
		Product p18 = productRepository.save(new Product(18L, "prod18", "Fleur-18", 11000.0, 1600.0, 150, "20.jpg",false, true, true, "prod1prod1prod1", "prod1prod1prod1", sc5));
		Product p19 = productRepository.save(new Product(19L, "prod19", "Fleur-19", 22000.0, 1300.0, 150, "28.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc1));
		Product p20 = productRepository.save(new Product(20L, "prod20", "Fleur-20", 14000.0, 1200.0, 150, "34.jpg",false, true, true, "prod1prod1prod1","prod1prod1prod1", sc6));

		*
		/

		/*
		State state1 = stateRepository.save(new State(1L, "Almadies", count1));
		State state2 = stateRepository.save(new State(2L, "Amitie", count1));
		State state3 = stateRepository.save(new State(3L, "Bambilor", count1));
		State state4 = stateRepository.save(new State(4L, "Bargny", count1));
		State state5 = stateRepository.save(new State(5L, "Bel Air", count1));
		State state6 = stateRepository.save(new State(6L, "Bop", count1));
		State state7 = stateRepository.save(new State(7L, "Camberene", count1));
		State state8 = stateRepository.save(new State(8L, "Castor", count1));
		State state9 = stateRepository.save(new State(9L, "Centenaire", count1));
		State state10 = stateRepository.save(new State(10L, "Cite Keur Damel", count1));
		State state11 = stateRepository.save(new State(11L, "Colobane", count1));
		State state12 = stateRepository.save(new State(12L, "Dalifort", count1));
		State state13 = stateRepository.save(new State(13L, "Derkle", count1));
		State state14 = stateRepository.save(new State(14L, "Diamaguene", count1));
		State state15 = stateRepository.save(new State(15L, "Diamalaye", count1));
		State state16 = stateRepository.save(new State(16L, "Diamniadio", count1));
		State state17 = stateRepository.save(new State(17L, "Diappeul", count1));
		State state18 = stateRepository.save(new State(18L, "Fann", count1));
		State state19 = stateRepository.save(new State(19L, "Fass", count1));
		State state20 = stateRepository.save(new State(20L, "Golf", count1));

*/

        /*
		Role useRole = roleRepository.save(new Role(RoleName.ROLE_USER));
        Role vendorRole = roleRepository.save(new Role(RoleName.ROLE_VENDOR));
		Role managerRole = roleRepository.save(new Role(RoleName.ROLE_MANAGER));
		Role adminRole = roleRepository.save(new Role(RoleName.ROLE_ADMIN));

        Utilisateur vendor = new Utilisateur();
        vendor.setId(1L);
        vendor.setUsername("Vendor");
        vendor.setName("Vendor");
        vendor.setActive(true);
        vendor.setPassword(bCryptPasswordEncoder.encode("vendorflower@2022"));
        utilisateurRepository.save(vendor);


        Utilisateur bertin = new Utilisateur();
        bertin.setId(2L);
        bertin.setUsername("Bertin");
        bertin.setName("Bertin Gbalou");
        bertin.setActive(true);
        bertin.setPassword(bCryptPasswordEncoder.encode("fleurpourtous@2022"));
        utilisateurRepository.save(bertin);

        Utilisateur adama = new Utilisateur();
        adama.setId(3L);
        adama.setUsername("thir");
        adama.setName("Tairou Diallo");
        adama.setActive(true);
        adama.setPassword(bCryptPasswordEncoder.encode("Windev2018"));
        utilisateurRepository.save(adama);

        Utilisateur admin = new Utilisateur();
        admin.setId(4L);
        admin.setUsername("Admin");
        admin.setName("Administrator");
        admin.setActive(true);
        admin.setPassword(bCryptPasswordEncoder.encode("Admin123456"));
        utilisateurRepository.save(admin);

        utilisateurService.addRoleToUser("Vendor", RoleName.ROLE_VENDOR);
        utilisateurService.addRoleToUser("Bertin", RoleName.ROLE_MANAGER);
        utilisateurService.addRoleToUser("thir", RoleName.ROLE_ADMIN);
        utilisateurService.addRoleToUser("Admin", RoleName.ROLE_ADMIN);



         */




    }


}
