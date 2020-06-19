package com.BeerTwoGun.service;

import com.BeerTwoGun.entity.Person;

public interface PersonService extends BaseService<Person> {
    Person createPerson(Person person);

    Person findByIdAndIfObjectIsNull(Long id);

}
