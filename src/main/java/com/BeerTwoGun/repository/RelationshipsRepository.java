package com.BeerTwoGun.repository;

import com.BeerTwoGun.entity.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipsRepository extends JpaRepository<Relationship,Long> {
}
