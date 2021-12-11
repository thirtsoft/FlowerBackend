package com.flowers.reposiory;

import com.flowers.models.Category;
import com.flowers.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findByOrderByIdDesc();

}
