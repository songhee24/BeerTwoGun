package com.BeerTwoGun.repository;

import com.BeerTwoGun.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends JpaRepository<Node,Long> {

}
