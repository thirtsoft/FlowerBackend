package com.flowers.repository;

import com.flowers.models.Fournisseur;
import com.flowers.models.Product;
import com.flowers.models.State;
import com.flowers.reposiory.FournisseurRepository;
import com.flowers.reposiory.ProductRepository;
import com.flowers.reposiory.StateRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FournisseurRepositoryTest {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StateRepository stateRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_fournisseur_Test() {
        Product product = new Product();
        product.setId(1L);
        product.setReference("PROD01");
        product.setDesignation("Prod01");
        productRepository.save(product);
        State state = new State();
        state.setId(1L);
        state.setName("Bignona");
        stateRepository.save(state);

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(1L);
        fournisseur.setFirstName("Tairou");
        fournisseur.setLastName("Diallo");
        fournisseur.setReference("FOUR01");
        fournisseur.setTelephone("779440310");
        fournisseur.setProduct(product);
        fournisseur.setState(state);

        assertThat(fournisseur.getId()).isGreaterThan(0);
        assertThat(fournisseur.getFirstName()).isNotNull();
        assertThat(fournisseur.getLastName()).isEqualTo("Diallo");
    }

    @Test
    @Order(2)
    public void get_and_return_on_fournisseur_by_Id_Test() {
        Optional<Fournisseur> optionalFournisseur = fournisseurRepository.findById(1L);
        if (optionalFournisseur.isPresent()) {
            assertThat(optionalFournisseur.get().getId()).isNotNull();
            assertThat(optionalFournisseur.get().getFirstName()).isNotNull();
            assertThat(optionalFournisseur.get().getTelephone()).isNotNull();
        }


    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void update_fournisseur_by_id_Test() {
        Optional<Fournisseur> optionalFournisseur = fournisseurRepository.findById(1L);
        if (optionalFournisseur.isPresent()) {
            Fournisseur fournisseur = optionalFournisseur.get();
            fournisseur.setFirstName("Saliou woury");

            Fournisseur fournisseurUpdated = fournisseurRepository.save(fournisseur);
            assertThat(fournisseurUpdated.getId()).isEqualTo(fournisseur.getId());
            assertThat(fournisseurUpdated.getFirstName()).isEqualTo("Saliou");
        }
    }

    @Test
    @Order(4)
    public void get_number_Of_fournisseur_Test() {
        BigDecimal number = fournisseurRepository.countNumberOfFournisseur();
        BigDecimal val = BigDecimal.valueOf(200);
        assertThat(number).isLessThan(val);
    }

    @Test
    @Order(5)
    public void should_and_return_all_fournisseurs_Test() {
        Product product = new Product();
        product.setId(1L);
        product.setReference("PROD01");
        product.setDesignation("Prod01");
        productRepository.save(product);
        State state = new State();
        state.setId(1L);
        state.setName("Bignona");
        stateRepository.save(state);
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(5L);
        fournisseur.setFirstName("Tairou");
        fournisseur.setLastName("Diallo");
        fournisseur.setReference("FOUR05");
        fournisseur.setTelephone("7790440310");
        fournisseur.setProduct(product);
        fournisseur.setState(state);
        fournisseurRepository.save(fournisseur);

        List<Fournisseur> fournisseurList = fournisseurRepository.findAll();

        assertThat(fournisseurList.size()).isNotNull();
        assertThat(fournisseurList.size()).isGreaterThan(0);
    }

    @Test
    @Order(6)
    public void should_and_return_all_fourisseurs_by_IdDesc_Test() {
        Product product = new Product();
        product.setId(1L);
        product.setReference("PROD01");
        product.setDesignation("Prod01");
        productRepository.save(product);
        State state = new State();
        state.setId(1L);
        state.setName("Bignona");
        stateRepository.save(state);
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(6L);
        fournisseur.setFirstName("Tairou");
        fournisseur.setLastName("Diallo");
        fournisseur.setReference("FOUR05");
        fournisseur.setTelephone("7790440310");
        fournisseur.setProduct(product);
        fournisseur.setState(state);
        fournisseurRepository.save(fournisseur);

        List<Fournisseur> fournisseurList = fournisseurRepository.findByOrderByIdDesc();

        assertThat(fournisseurList.size()).isNotNull();
        assertThat(fournisseurList.size()).isGreaterThan(0);
    }

    @Test
    @Order(7)
    @Rollback(value = false)
    public void delete_fournisseur_by_id_Test() {
        Optional<Fournisseur> optionalFournisseur = fournisseurRepository.findById(1L);
        if (optionalFournisseur.isPresent()) {
            fournisseurRepository.delete(optionalFournisseur.get());
        }
        Fournisseur fournisseur = null;
        Optional<Fournisseur> optionalFournisseur01 = fournisseurRepository.findById(1L);
        if (optionalFournisseur01.isPresent()) {
            fournisseur = optionalFournisseur01.get();
        }
        assertThat(fournisseur).isNull();
    }

}
