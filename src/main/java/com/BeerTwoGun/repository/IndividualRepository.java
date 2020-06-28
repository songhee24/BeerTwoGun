package com.BeerTwoGun.repository;

import com.BeerTwoGun.entity.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<Individual,Long> {
    Individual getById(Long id);

}

