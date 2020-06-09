package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.FamilyMember;
import com.BeerTwoGun.repository.FamilyMemberRepository;
import com.BeerTwoGun.service.FamilyMemberIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyMemberImpl implements FamilyMemberIService {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Override
    public FamilyMember save(FamilyMember item) {
        return familyMemberRepository.save(item);
    }

    @Override
    public List<FamilyMember> findAll() {
        return familyMemberRepository.findAll();
    }

    @Override
    public FamilyMember findById(Long id) {
        return familyMemberRepository.findById(id).orElse(new FamilyMember());
    }

    @Override
    public boolean delete(Long id) {
        if(familyMemberRepository.findById(id).isPresent()){
            familyMemberRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
