package com.example.lazy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "man")
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "man-entity-graph",
                attributeNodes = {
                        @NamedAttributeNode(value = "address")
                }
        )
})
public class Man {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "man_seq_gen", allocationSize = 1)
    Long id;
    String firstName;
    String lastName;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Address address;
}
