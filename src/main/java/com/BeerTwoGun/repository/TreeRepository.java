package com.BeerTwoGun.repository;

import com.BeerTwoGun.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeRepository extends JpaRepository<Tree,Long> {
      List<Tree> getAllByTreeParentIdIsNotNull();
}
