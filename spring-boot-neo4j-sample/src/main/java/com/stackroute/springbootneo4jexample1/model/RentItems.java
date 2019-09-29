package com.stackroute.springbootneo4jexample1.model;

import lombok.*;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RentItems {

    @GraphId
    private Long itemId;
    private String itemName;
    private String itemDescription;


}
