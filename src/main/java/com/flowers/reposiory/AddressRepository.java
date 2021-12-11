package com.flowers.reposiory;

import com.flowers.models.Address;
import com.flowers.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByOrderByIdDesc();

}
