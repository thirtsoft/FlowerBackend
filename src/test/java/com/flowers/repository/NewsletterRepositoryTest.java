package com.flowers.repository;

import com.flowers.models.Newsletter;
import com.flowers.reposiory.NewsletterRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NewsletterRepositoryTest {

    @Autowired
    private NewsletterRepository newsletterRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_newsletter_Test() {
        Newsletter newsletter = new Newsletter();
        newsletter.setId(1L);
        newsletter.setCustomerEmail("thirdiallo@gmail.com");
        newsletter.setCode("NEWS01");
        newsletter.setDateInscription(new Date());
        newsletterRepository.save(newsletter);

        assertThat(newsletter.getId()).isGreaterThan(0);
        assertThat(newsletter.getCode()).isEqualTo("NEWS01");
        assertThat(newsletter.getCustomerEmail()).isEqualTo("thirdiallo@gmail.com");
    }

    @Test
    @Order(2)
    public void get_and_return_on_newsletter_by_Id_Test() {
        Newsletter newsletter = new Newsletter();
        newsletter.setId(1L);
        newsletter.setCustomerEmail("thirdiallo@gmail.com");
        newsletter.setCode("NEWS01");
        newsletter.setDateInscription(new Date());
        newsletterRepository.save(newsletter);

        Newsletter optionalNewsletter = newsletterRepository.findById(1L).get();

        assertThat(optionalNewsletter.getId()).isEqualTo(newsletter.getId());
        assertThat(optionalNewsletter.getCustomerEmail()).isEqualTo(newsletter.getCustomerEmail());
        assertThat(optionalNewsletter.getCode()).isEqualTo("NEWS01");
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void update_newsletter_by_id_Test() {
        Optional<Newsletter> optionalNewsletter = newsletterRepository.findById(1L);
        if (optionalNewsletter.isPresent()) {
            Newsletter newsletter = optionalNewsletter.get();
            newsletter.setCode("233");

            Newsletter newsletterUpdated = newsletterRepository.save(newsletter);
            assertThat(newsletterUpdated.getId()).isEqualTo(newsletter.getId());
            assertThat(newsletterUpdated.getCode()).isEqualTo(newsletter.getCode());
        }
    }


    @Test
    @Order(4)
    public void should_and_return_all_newsletters_Test() {
        Newsletter newsletter = new Newsletter();
        newsletter.setId(1L);
        newsletter.setCustomerEmail("thirdiallo@gmail.com");
        newsletter.setCode("NEWS01");
        newsletter.setDateInscription(new Date());
        newsletterRepository.save(newsletter);

        List<Newsletter> newsletterList = newsletterRepository.findAll();

        assertThat(newsletterList.size()).isNotNull();
        assertThat(newsletterList.size()).isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void should_and_return_all_newsletters_by_IdDesc_Test() {
        Newsletter newsletter = new Newsletter();
        newsletter.setId(1L);
        newsletter.setCustomerEmail("thirdiallo@gmail.com");
        newsletter.setCode("NEWS01");
        newsletter.setDateInscription(new Date());
        newsletterRepository.save(newsletter);

        List<Newsletter> newsletterList = newsletterRepository.findByOrderByIdDesc();

        assertThat(newsletterList.size()).isNotNull();
        assertThat(newsletterList.size()).isGreaterThan(0);
    }


    @Test
    @Order(6)
    @Rollback(value = false)
    public void delete_ligne_Commande_by_id_Test() {
        Optional<Newsletter> optionalNewsletter = newsletterRepository.findById(1L);
        if (optionalNewsletter.isPresent()) {
            newsletterRepository.delete(optionalNewsletter.get());
        }
        Newsletter newsletter = null;
        Optional<Newsletter> optionalNewsletter01 = newsletterRepository.findById(1L);
        if (optionalNewsletter01.isPresent()) {
            newsletter = optionalNewsletter01.get();
        }
        assertThat(newsletter).isNull();
    }

}
