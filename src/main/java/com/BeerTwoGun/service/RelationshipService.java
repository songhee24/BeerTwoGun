package com.BeerTwoGun.service;

import com.BeerTwoGun.entity.Relationship;

import java.util.List;
import java.util.Optional;


public interface RelationshipService extends BaseService<Relationship> {
    Relationship create(Relationship relationship, List<Optional<Long>> individualId,List<Optional<Long>> familyId);
}
