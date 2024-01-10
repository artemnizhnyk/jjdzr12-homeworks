package com.isa.bookcase.dto;

import com.isa.bookcase.enumeration.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;

    @NotBlank
    private String author;

    @NotBlank
    private String title;

    @NotNull
    private Category category;

    @NotNull
    @Positive
    private Integer pages;

    @NotNull
    private Boolean forKids;
}