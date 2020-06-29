package com.BeerTwoGun.service;

import com.BeerTwoGun.entity.Individual;

public interface IndividualService extends BaseService<Individual> {
    Individual createIndividual(Individual individual);

    Individual findByIdAndIfObjectIsNull(Long id);

    Long getIdByIndividualId(Long id);

}
