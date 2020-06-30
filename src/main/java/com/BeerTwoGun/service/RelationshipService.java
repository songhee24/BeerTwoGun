package com.BeerTwoGun.service;

import com.BeerTwoGun.entity.Relationship;




public interface RelationshipService extends BaseService<Relationship> {
    Relationship create(Relationship relationship);
}
