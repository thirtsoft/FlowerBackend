package com.flowers.repository;

import com.flowers.models.Role;
import com.flowers.models.Utilisateur;
import com.flowers.reposiory.RoleRepository;
import com.flowers.reposiory.UtilisateurRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static com.flowers.enums.RoleName.ROLE_USER;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UtilisateurRepositoryTest {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_utilisateur_Test() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setName("Tairou");
        utilisateur.setUsername("thir");
        utilisateur.setMobile("779440310");
        utilisateurRepository.save(utilisateur);

        assertThat(utilisateur.getId()).isGreaterThan(0);
        assertThat(utilisateur.getUsername()).isNotNull();
        assertThat(utilisateur.getName()).isEqualTo("Tairou");
    }

    @Test
    @Order(2)
    public void get_and_return_on_utilisateur_by_Id_Test() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(2L);
        utilisateur.setName("TairouDiallo");
        utilisateur.setUsername("thirById");
        utilisateur.setMobile("7794147540310");
        utilisateurRepository.save(utilisateur);

        Utilisateur optionalUtilisateur = utilisateurRepository.findById(utilisateur.getId()).get();

        assertThat(optionalUtilisateur.getId()).isEqualTo(utilisateur.getId());
        assertThat(optionalUtilisateur.getName()).isEqualTo(utilisateur.getName());
    }

    @Test
    @Order(3)
    public void get_and_return_on_utilisateur_by_username_Test() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(3L);
        utilisateur.setName("TairouDialloTairou");
        utilisateur.setUsername("thirByUsername");
        utilisateur.setMobile("7794147478540310");
        utilisateurRepository.save(utilisateur);

        Utilisateur optionalUtilisateur = utilisateurRepository.findByUsername(utilisateur.getUsername()).get();

        assertThat(optionalUtilisateur.getId()).isNotNull();
        assertThat(optionalUtilisateur.getUsername()).isEqualTo("thirByUsername");
    }


    @Test
    @Order(4)
    @Rollback(value = false)
    public void update_utilisateur_by_id_Test() {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(1L);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            utilisateur.setName("Materiel");
            Utilisateur utilisateurUpdated = utilisateurRepository.save(utilisateur);
            assertThat(utilisateurUpdated.getId()).isEqualTo(utilisateur.getId());
            assertThat(utilisateurUpdated.getName()).isEqualTo("Materiel");
        }
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void add_role_to_utilisateur_Test() {
        Role role = new Role();
        role.setId(1L);
        role.setName(ROLE_USER);
        roleRepository.save(role);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(4L);
        utilisateur.setName("TairouRole");
        utilisateur.setUsername("thirByRole");
        utilisateur.setMobile("78540310");
        utilisateur.getRoles().add(role);
        utilisateurRepository.save(utilisateur);

        assertThat(utilisateur.getRoles()).isNotNull();
    }

    @Test
    @Order(6)
    public void should_and_return_all_utilisateurs_Test() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(5L);
        utilisateur.setName("TairouDiallo");
        utilisateur.setUsername("thirById");
        utilisateur.setMobile("7794147540310");
        utilisateurRepository.save(utilisateur);
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();

        assertThat(utilisateurList.size()).isNotNull();
        assertThat(utilisateurList.size()).isGreaterThan(0);
    }

    @Test
    @Order(7)
    public void should_and_return_all_utilisateurs_by_IdDesc_Test() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(6L);
        utilisateur.setName("TairouDiallo");
        utilisateur.setUsername("thirById");
        utilisateur.setMobile("7794147540310");
        utilisateurRepository.save(utilisateur);
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();

        assertThat(utilisateurList.size()).isNotNull();
        assertThat(utilisateurList.size()).isGreaterThan(0);
    }

    @Test
    @Order(8)
    public void update_username_of_utilisateur_by_username_Test() {
        String username = "Username";
        String newUsername = "newUsername";
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findByUsername(username);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            utilisateur.setUsername(newUsername);
            Utilisateur utilisateurUpdated = utilisateurRepository.save(utilisateur);
            assertThat(utilisateurUpdated.getId()).isEqualTo(utilisateur.getId());
            assertThat(utilisateurUpdated.getUsername()).isEqualTo("newUsername");
        }

    }

    @Test
    @Order(9)
    public void update_username_of_utilisateur_by_id_Test() {
        Long userId = 3L;
        String newUsername = "newUsername";
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(userId);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            utilisateur.setUsername(newUsername);
            Utilisateur utilisateurUpdated = utilisateurRepository.save(utilisateur);
            assertThat(utilisateurUpdated.getId()).isEqualTo(utilisateur.getId());
            assertThat(utilisateurUpdated.getUsername()).isEqualTo("newUsername");
        }

    }

    @Test
    @Order(10)
    @Rollback(value = false)
    public void delete_utilisateur_by_id_Test() {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(1L);
        if (optionalUtilisateur.isPresent()) {
            utilisateurRepository.delete(optionalUtilisateur.get());
        }
        Utilisateur utilisateur = null;
        Optional<Utilisateur> optionalUtilisateur01 = utilisateurRepository.findById(1L);
        if (optionalUtilisateur01.isPresent()) {
            utilisateur = optionalUtilisateur.get();
        }
        assertThat(utilisateur).isNull();
    }


}
