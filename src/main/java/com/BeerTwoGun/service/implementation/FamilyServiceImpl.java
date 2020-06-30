package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.Family;
import com.BeerTwoGun.entity.Individual;
import com.BeerTwoGun.repository.FamilyRepository;
import com.BeerTwoGun.service.FamilyService;
import com.BeerTwoGun.service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private IndividualService individualService;

    @Override
    public Family save(Family item) {
        return familyRepository.save(item);
    }

    @Override
    public List<Family> findAll() {
        return familyRepository.findAll();
    }

    @Override
    public Family findById(Long id) {
        return familyRepository.findById(id).orElse(new Family());
    }

    @Override
    public boolean delete(Long id) {
        if(familyRepository.findById(id).isPresent()){
            familyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Family create(Family family,Long head1id,Long head2id) {
        System.err.println("head1service:" + head1id);
        System.err.println("head2service:" + head2id);
        System.err.println();
        Individual head1 = new Individual();
        Individual head2 = new Individual();
             if (head1id != null){
                 head1 = individualService.findById(head1id);
             }
             if (head2id != null){
                 head2 = individualService.findById(head2id);
             }


        family.setFamilyHead1Id(head1);
        family.setFamilyHead2Id(head2);
        return save(family);
    }
}
