package com.BeerTwoGun.repository.repoTypes;

import com.BeerTwoGun.entity.typesEntity.RelationshipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipTypeRepository extends JpaRepository<RelationshipType,Long> {
}
