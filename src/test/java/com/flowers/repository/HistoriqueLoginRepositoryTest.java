package com.flowers.repository;

import com.flowers.models.HistoriqueLogin;
import com.flowers.models.Utilisateur;
import com.flowers.reposiory.HistoriqueLoginRepository;
import com.flowers.reposiory.UtilisateurRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HistoriqueLoginRepositoryTest {

    @Autowired
    private HistoriqueLoginRepository historiqueLoginRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_HistoriqueLogin_Test() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setName("Tairou");
        utilisateur.setUsername("thir");
        utilisateur.setMobile("779440310");
        utilisateurRepository.save(utilisateur);

        HistoriqueLogin historiqueLogin = new HistoriqueLogin();
        historiqueLogin.setId(1L);
        historiqueLogin.setUtilisateur(utilisateur);
        historiqueLogin.setAction("SE CONNECTER");
        historiqueLogin.setCreatedDate(new Date());
        historiqueLoginRepository.save(historiqueLogin);

        assertThat(historiqueLogin.getId()).isGreaterThan(0);
        assertThat(historiqueLogin.getAction()).isEqualTo("SE CONNECTER");
        assertThat(historiqueLogin.getUtilisateur()).isEqualTo(utilisateur);
    }

    @Test
    @Order(2)
    public void get_and_return_on_historique_Login_by_Id_Test() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setName("Tairou");
        utilisateur.setUsername("thirdiallo");
        utilisateur.setMobile("77944037710");
        utilisateurRepository.save(utilisateur);

        HistoriqueLogin historiqueLogin = new HistoriqueLogin();
        historiqueLogin.setId(1L);
        historiqueLogin.setUtilisateur(utilisateur);
        historiqueLogin.setAction("RECHER HISTO LOG");
        historiqueLogin.setCreatedDate(new Date());
        historiqueLoginRepository.save(historiqueLogin);

        HistoriqueLogin optionalHistoriqueLogin = historiqueLoginRepository.findById(1L).get();

        assertThat(optionalHistoriqueLogin.getId()).isEqualTo(historiqueLogin.getId());
        assertThat(optionalHistoriqueLogin.getUtilisateur()).isEqualTo(historiqueLogin.getUtilisateur());
        assertThat(optionalHistoriqueLogin.getAction()).isEqualTo("RECHER HISTO LOG");
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void update_historiqueLogin_by_id_Test() {
        Optional<HistoriqueLogin> optionalHistoriqueLogin = historiqueLoginRepository.findById(1L);
        if (optionalHistoriqueLogin.isPresent()) {
            HistoriqueLogin historiqueLogin = optionalHistoriqueLogin.get();
            historiqueLogin.setAction("SUPP COM");

            HistoriqueLogin historiqueLoginUpdated = historiqueLoginRepository.save(historiqueLogin);
            assertThat(historiqueLoginUpdated.getId()).isEqualTo(historiqueLogin.getId());
            assertThat(historiqueLoginUpdated.getAction()).isEqualTo("SUPP COM");
        }
    }

    @Test
    @Order(4)
    public void get_number_Of_historique_Login_Test() {
        BigDecimal number = historiqueLoginRepository.countNumberOfHistoriqueLogins();
        BigDecimal val = BigDecimal.valueOf(200);
        assertThat(number).isLessThan(val);
    }

    @Test
    @Order(5)
    public void should_and_return_all_historique_Logins_Test() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setName("Tairou");
        utilisateur.setUsername("alpha");
        utilisateur.setMobile("77944031078");
        utilisateurRepository.save(utilisateur);

        HistoriqueLogin historiqueLogin = new HistoriqueLogin();
        historiqueLogin.setId(1L);
        historiqueLogin.setUtilisateur(utilisateur);
        historiqueLogin.setAction("RECHER HISTOS LOGS");
        historiqueLogin.setCreatedDate(new Date());
        historiqueLoginRepository.save(historiqueLogin);


        List<HistoriqueLogin> historiqueLoginList = historiqueLoginRepository.findAll();

        assertThat(historiqueLoginList.size()).isNotNull();
        assertThat(historiqueLoginList.size()).isGreaterThan(0);
    }

    @Test
    @Order(6)
    public void should_and_return_all_historique_Logins_by_IdDesc_Test() {

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setName("Tairou");
        utilisateur.setUsername("thirma");
        utilisateur.setMobile("7794403174850");
        utilisateurRepository.save(utilisateur);

        HistoriqueLogin historiqueLogin = new HistoriqueLogin();
        historiqueLogin.setId(1L);
        historiqueLogin.setUtilisateur(utilisateur);
        historiqueLogin.setAction("RECHER HISTOS LOGS");
        historiqueLogin.setCreatedDate(new Date());
        historiqueLoginRepository.save(historiqueLogin);


        List<HistoriqueLogin> historiqueLoginList = historiqueLoginRepository.findByOrderByIdDesc();

        assertThat(historiqueLoginList.size()).isNotNull();
        assertThat(historiqueLoginList.size()).isGreaterThan(0);
    }

    @Test
    @Order(7)
    @Rollback(value = false)
    public void delete_HistoriqueLogin_by_id_Test() {
        Optional<HistoriqueLogin> optionalHistoriqueLogin = historiqueLoginRepository.findById(1L);
        if (optionalHistoriqueLogin.isPresent()) {
            historiqueLoginRepository.delete(optionalHistoriqueLogin.get());
        }
        HistoriqueLogin historiqueLogin = null;
        Optional<HistoriqueLogin> optionalHistoriqueLogin01 = historiqueLoginRepository.findById(1L);
        if (optionalHistoriqueLogin01.isPresent()) {
            historiqueLogin = optionalHistoriqueLogin01.get();
        }
        assertThat(historiqueLogin).isNull();
    }

}
