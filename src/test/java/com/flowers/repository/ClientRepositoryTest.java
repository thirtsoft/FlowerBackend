package com.flowers.repository;

import com.flowers.models.Category;
import com.flowers.models.Client;
import com.flowers.reposiory.ClientRepository;
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
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_client_Test() {
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Tairou");
        client.setLastName("Diallo");
        client.setMobile("779440310");
        client.setEmail("thirdiallo@gmail.com");
        clientRepository.save(client);

        assertThat(client.getId()).isGreaterThan(0);
        assertThat(client.getFirstName()).isNotNull();
        assertThat(client.getLastName()).isEqualTo("Diallo");
    }

    @Test
    @Order(2)
    public void get_and_return_on_client_by_Id_Test() {
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Tairou");
        client.setLastName("Diallo");
        client.setMobile("779440310");
        client.setEmail("thirdiallo@gmail.com");
        clientRepository.save(client);

        Client optionalClient = clientRepository.findById(1L).get();

        assertThat(optionalClient.getId()).isEqualTo(client.getId());
        assertThat(optionalClient.getEmail()).isEqualTo(client.getEmail());
        assertThat(optionalClient.getMobile()).isEqualTo("779440310");
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void update_client_by_id_Test() {
        Optional<Client> optionalClient = clientRepository.findById(1L);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setFirstName("Saliou");

            Client clientUpdated = clientRepository.save(client);
            assertThat(clientUpdated.getId()).isEqualTo(client.getId());
            assertThat(clientUpdated.getFirstName()).isEqualTo("Saliou");
        }
    }

    @Test
    @Order(4)
    public void get_number_Of_client_Test() {
        BigDecimal number = clientRepository.countNumberOfClient();
        BigDecimal val = BigDecimal.valueOf(200);
        assertThat(number).isLessThan(val);
    }

    @Test
    @Order(5)
    public void should_and_return_all_clients_Test() {
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Tairou");
        client.setLastName("Diallo");
        client.setMobile("779440310");
        client.setEmail("thirdiallo@gmail.com");
        clientRepository.save(client);

        List<Client> clientList = clientRepository.findAll();

        assertThat(clientList.size()).isNotNull();
        assertThat(clientList.size()).isGreaterThan(0);
    }

    @Test
    @Order(6)
    public void should_and_return_all_clients_by_IdDesc_Test() {
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Tairou");
        client.setLastName("Diallo");
        client.setMobile("779440310");
        client.setEmail("thirdiallo@gmail.com");
        clientRepository.save(client);

        List<Client> clientList = clientRepository.findByOrderByIdDesc();

        assertThat(clientList.size()).isNotNull();
        assertThat(clientList.size()).isGreaterThan(0);
    }

    @Test
    @Order(7)
    @Rollback(value = false)
    public void delete_client_by_id_Test() {
        Optional<Client> optionalClient = clientRepository.findById(1L);
        if (optionalClient.isPresent()) {
            clientRepository.delete(optionalClient.get());
        }
        Client client = null;
        Optional<Client> optionalClient01 = clientRepository.findById(1L);
        if (optionalClient01.isPresent()) {
            client = optionalClient01.get();
        }
        assertThat(client).isNull();
    }

}
