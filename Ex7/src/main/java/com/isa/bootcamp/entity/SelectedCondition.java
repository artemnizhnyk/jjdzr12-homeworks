package com.isa.bootcamp.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SelectedCondition {
    @Enumerated(EnumType.STRING)
    private SortOrFilterOption sortOrFilterOption;
}

