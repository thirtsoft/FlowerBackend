package com.flowers;

import com.flowers.enums.RoleName;
import com.flowers.models.*;
import com.flowers.reposiory.*;
import com.flowers.services.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired private UtilisateurService utilisateurService;

    /*
    @Autowired
    private PasswordEncoder passwordEncoder;
    */


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

		Role useRole = roleRepository.save(new Role(RoleName.ROLE_USER));
        Role vendorRole = roleRepository.save(new Role(RoleName.ROLE_VENDOR));
		Role managerRole = roleRepository.save(new Role(RoleName.ROLE_MANAGER));
		Role adminRole = roleRepository.save(new Role(RoleName.ROLE_ADMIN));

/*
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

/*
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
