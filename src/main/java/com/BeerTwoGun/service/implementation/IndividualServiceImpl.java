package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.DateConvert;
import com.BeerTwoGun.entity.Individual;
import com.BeerTwoGun.repository.IndividualRepository;
import com.BeerTwoGun.service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IndividualServiceImpl implements IndividualService {
      @Autowired
      private IndividualRepository individualRepository;



    @Override
    public Individual save(Individual item) {
        return individualRepository.save(item);
    }

    @Override
    public List<Individual> findAll() {
        return individualRepository.findAll();
    }

    @Override
    public Individual findByIdAndIfObjectIsNull(Long id) {
        try {
            Individual knotParentId = findById(id);
            Optional<Individual> parentOptional = Optional.ofNullable(knotParentId);
            Individual ifIndividualNull;

                long count = 0;
                if (!parentOptional.isPresent()){
                    ifIndividualNull = Individual.builder().id(++count).build();
                    return ifIndividualNull;
                }


        } catch (NullPointerException nullPointer){
            nullPointer.getStackTrace();
        }
        return null;
    }



    @Override
    public Individual findById(Long id) {
        return individualRepository.findById(id).orElse(new Individual());
    }

    @Override
    public boolean delete(Long id) {
        if (individualRepository.findById(id).isPresent()){
            individualRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Long getIdByIndividualId(Long id) {
        Individual individual = findById(id);
        return individual.getId();
    }

    @Override
    public Individual createIndividual(Individual individual) {
        String sDate = individual.getDateBirth().toString();
        if (individual.getDateDeath() != null){
            String sDeath = individual.getDateDeath().toString();
            LocalDate dateD = DateConvert.getDateFromString(sDeath);
            individual.setDateDeath(dateD);
        }
        LocalDate dateB = DateConvert.getDateFromString(sDate);
        individual.setDateBirth(dateB);
        return save(individual);
    }
}

