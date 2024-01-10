package com.isa.bookcase.model;

import com.isa.bookcase.enumeration.Category;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book extends AbstractEntity {
    @ManyToOne
    private Author author;
    private String title;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Integer pages;
    private Boolean forKids;

}