package com.isa.bookcase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author extends AbstractEntity {

    private String name;
    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Book> books = new ArrayList<>();
}