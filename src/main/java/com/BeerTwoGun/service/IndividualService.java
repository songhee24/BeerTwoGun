package com.BeerTwoGun.service;

import com.BeerTwoGun.entity.Individual;

public interface IndividualService extends BaseService<Individual> {
    Individual individualPerson(Individual individual);

    Individual findByIdAndIfObjectIsNull(Long id);

}
