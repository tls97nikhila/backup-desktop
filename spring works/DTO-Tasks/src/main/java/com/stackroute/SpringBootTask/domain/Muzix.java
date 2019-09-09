package com.stackroute.SpringBootTask.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "Muzix")
public class Muzix {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String comment;

}
