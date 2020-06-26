package com.BeerTwoGun.service;

import com.BeerTwoGun.entity.Tree;

import java.util.List;

public interface TreeService extends BaseService<Tree> {
    Tree createTree(Tree tree, List<Long> parent_Id, List<Long> child_Id);
}
