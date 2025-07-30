package com.abhinav.base.entityManyToMany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Book {
    @Id
    private Long id;
    private String bookName;

    @ManyToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Author> author;
}
