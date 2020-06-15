package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.DateConvert;
import com.BeerTwoGun.entity.FamilyMember;
import com.BeerTwoGun.entity.Person;
import com.BeerTwoGun.repository.FamilyMemberRepository;
import com.BeerTwoGun.service.FamilyMemberIService;
import com.BeerTwoGun.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FamilyMemberImpl implements FamilyMemberIService {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    private PersonService personService;

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
    public FamilyMember createMember(FamilyMember familyMember) {
        String sDate = familyMember.getBirthDate().toString();
        LocalDate date = DateConvert.getDateFromString(sDate);
        familyMember.setBirthDate(date);

        Person person = personService.findById(familyMember.getPersonId().getId());
        familyMember.setPersonId(person);
        return save(familyMember);
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
