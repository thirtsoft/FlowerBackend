package com.flowers.reposiory;

import com.flowers.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByOrderByIdDesc();

    @Query("Select DISTINCT act from  Address act where act.actif=1 ORDER BY act.id desc")
    List<Address> findAll();

}
