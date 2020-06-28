package com.BeerTwoGun.repository;

import com.BeerTwoGun.entity.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation,Long> {
}
