package com.BeerTwoGun.service;

import com.BeerTwoGun.entity.Node;

import java.util.List;
import java.util.Optional;

public interface NodeService extends BaseService<Node> {
    Node createTree(Node node, List<Optional<Long>> parent_Id, List<Optional<Long>> child_Id);
}
