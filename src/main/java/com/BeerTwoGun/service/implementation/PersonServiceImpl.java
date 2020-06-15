package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.DateConvert;
import com.BeerTwoGun.entity.Person;
import com.BeerTwoGun.repository.PersonRepository;
import com.BeerTwoGun.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
      @Autowired
      private PersonRepository personRepository;



    @Override
    public Person save(Person item) {
        return personRepository.save(item);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElse(new Person());
    }

    @Override
    public boolean delete(Long id) {
        if (personRepository.findById(id).isPresent()){
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Person createPerson(Person person) {
        String sDate = person.getBirthDate().toString();
        LocalDate dateFromString = DateConvert.getDateFromString(sDate);
        person.setBirthDate(dateFromString);

        return save(person);
    }
}

