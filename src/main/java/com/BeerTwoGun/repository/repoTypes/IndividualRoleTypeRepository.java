package com.BeerTwoGun.repository.repoTypes;

import com.BeerTwoGun.entity.typesEntity.IndividualRoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRoleTypeRepository extends JpaRepository<IndividualRoleType,Long> {
}
