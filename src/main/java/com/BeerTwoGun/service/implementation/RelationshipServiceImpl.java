package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.DateConvert;
import com.BeerTwoGun.entity.Family;
import com.BeerTwoGun.entity.Individual;
import com.BeerTwoGun.entity.Relationship;
import com.BeerTwoGun.repository.RelationshipsRepository;
import com.BeerTwoGun.service.FamilyService;
import com.BeerTwoGun.service.IndividualService;
import com.BeerTwoGun.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RelationshipServiceImpl implements RelationshipService {
    @Autowired
    private RelationshipsRepository relationshipsRepository;

    @Autowired
    private IndividualService individualService;

    @Autowired
    private FamilyService familyService;

    @Override
    public Relationship save(Relationship item) {
        return relationshipsRepository.save(item);
    }

    @Override
    public List<Relationship> findAll() {
        return relationshipsRepository.findAll();
    }

    @Override
    public Relationship findById(Long id) {
        return relationshipsRepository.findById(id).orElse(new Relationship());
    }

    @Override
    public boolean delete(Long id) {
        if (relationshipsRepository.findById(id).isPresent()){
            relationshipsRepository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public Relationship create(Relationship relationship,
                               List<Optional<Long>> individualId,
                               List<Optional<Long>> familyId) {

        Set<Individual> individuals = new HashSet<>();
        Set<Family> families = new HashSet<>();
        List<Long> iId = new ArrayList<>();
        List<Long> fId = new ArrayList<>();

        String bDate = relationship.getRelationshipDateStart().toString();
        LocalDate dateStart = DateConvert.getDateFromString(bDate);
        relationship.setRelationshipDateStart(dateStart);
        if (relationship.getRelationshipDateEnd() != null){
            String dateEnd = relationship.getRelationshipDateEnd().toString();
            LocalDate dateEnds = DateConvert.getDateFromString(dateEnd);
            relationship.setRelationshipDateEnd(dateEnds);
        }
        if (!(individualId == null)){
            for (int i = 0;i < individualId.size();i++){
                     iId = individualId.stream()
                            .filter((Optional::isPresent))
                            .map(Optional::get)
                            .collect(Collectors.toList());
                    individuals.add(individualService.findById(iId.get(i)));


            }
            System.err.println("individuals:" + iId);
        }
        if (!(familyId == null)){
            for (int f = 0;f < familyId.size();f++){
                    fId = familyId.stream()
                            .filter((Optional::isPresent))
                            .map(Optional::get)
                            .collect(Collectors.toList());
                    families.add(familyService.findById(fId.get(f)));

            }
            System.err.println("family:" + fId);

        }

        relationship.setIndividualHead1(individuals);
        relationship.setFamilies(families);
        return save(relationship);
    }
}
