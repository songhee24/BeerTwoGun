package com.BeerTwoGun.service;

import com.BeerTwoGun.entity.Family;

public interface FamilyService extends BaseService<Family> {
    Family create(Family family,Long head1id,Long head2id);
}
