package com.BeerTwoGun.repository.repoTypes;

import com.BeerTwoGun.entity.typesEntity.OccupationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationTypeRepository extends JpaRepository<OccupationType,Long> {
}
