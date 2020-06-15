package com.BeerTwoGun.service;

import com.BeerTwoGun.entity.FamilyMember;

public interface FamilyMemberIService extends BaseService<FamilyMember> {
    FamilyMember createMember(FamilyMember familyMember);
}
