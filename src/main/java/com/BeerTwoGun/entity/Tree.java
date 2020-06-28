package com.BeerTwoGun.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tree")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long Id;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "node_id")
    List<Node> nodeList;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    Tree treeParentId;
}
