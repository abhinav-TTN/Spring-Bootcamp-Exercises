package com.abhinav.base.entityOneToManyBiDirection;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
    @Id
    private Long id;
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
