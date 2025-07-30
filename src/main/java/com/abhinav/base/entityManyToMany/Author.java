package com.abhinav.base.entityManyToMany;

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

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Book> book = new ArrayList<>();
}
