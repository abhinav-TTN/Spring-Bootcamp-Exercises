package com.abhinav.base.entityOneToManyBiDirection;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;

    @Embedded
    private Address address;

    List<String> subjects;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> book = new ArrayList<>();
}
