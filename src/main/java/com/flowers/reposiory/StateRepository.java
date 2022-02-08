package com.flowers.reposiory;

import com.flowers.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findByOrderByIdDesc();

    @Query("select p from State p where p.country.code =:code")
    List<State> findAllStateByCountryCode(@Param("code") String code);

}
