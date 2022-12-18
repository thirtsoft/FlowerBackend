package com.flowers.repository;

import com.flowers.models.Address;
import com.flowers.reposiory.AddressRepository;
import org.assertj.core.api.Assertions;
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

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveAddressTest() {
        Address address = new Address();
        address.setZipcode("233");
        address.setRue("Rue 10");
        address.setCity("Address01");
        addressRepository.save(address);

        assertThat(address.getId()).isGreaterThan(0);
        assertThat(address.getZipcode()).isNotNull();
        assertThat(address.getRue()).isEqualTo("Rue 10");
        String city = "Address01";
        assertThat(city).isEqualTo(address.getCity());
    }

    @Test
    @Order(2)
    public void getAddressByIdTest() {
        Address address = new Address();
        address.setZipcode("233");
        address.setRue("Rue 10");
        address.setCity("Address01");
        addressRepository.save(address);

        Address optionalAddress = addressRepository.findById(address.getId()).get();
        assertThat(optionalAddress.getId()).isEqualTo(address.getId());
        assertThat(optionalAddress.getRue()).isEqualTo(address.getRue());
        assertThat(optionalAddress.getCity()).isEqualTo("Address01");
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateAddressTest() {
        Optional<Address> optionalAddress = addressRepository.findById(1L);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            address.setCity("Dakar");

            Address addressUpdated = addressRepository.save(address);
            Assertions.assertThat(addressUpdated.getCity()).isEqualTo("Dakar");
        }
    }

    @Test
    @Order(4)
    public void getListOfAdressesTest() {
        Address address = new Address();
        address.setZipcode("233");
        address.setRue("Rue 10");
        address.setCity("Address01");
        addressRepository.save(address);
        List<Address> addressList = addressRepository.findAll();
        assertThat(addressList.size()).isNotNull();
        assertThat(addressList.size()).isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void getListOfAdressesByIdDescTest() {
        Address address = new Address();
        address.setZipcode("233");
        address.setRue("Rue 10");
        address.setCity("Address01");
        addressRepository.save(address);
        List<Address> addressList = addressRepository.findByOrderByIdDesc();
        assertThat(addressList.size()).isNotNull();
        assertThat(addressList.size()).isGreaterThan(0);
    }

    @Test
    @Order(6)
    @Rollback(value = false)
    public void deleteAddressTest() {
        Optional<Address> optionalAddress = addressRepository.findById(1L);
        if (optionalAddress.isPresent()) {
            addressRepository.delete(optionalAddress.get());
        }
        Address address = null;
        Optional<Address> optionalAddress1 = addressRepository.findById(1L);
        if (optionalAddress1.isPresent()) {
            address = optionalAddress1.get();
        }
        Assertions.assertThat(address).isNull();
    }


}
