package com.BeerTwoGun.service;

import com.BeerTwoGun.entity.Node;

import java.util.List;

public interface NodeService extends BaseService<Node> {
    Node createTree(Node node, List<Long> parent_Id, List<Long> child_Id);
}
