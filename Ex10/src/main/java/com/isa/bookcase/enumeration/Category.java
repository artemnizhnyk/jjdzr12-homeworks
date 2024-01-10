package com.isa.bookcase.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    
    KRYMINAL_SENSACJA_THRILLER("kryminał, sensacja, thriller"),
    LITERATURA_PIEKNA("literatura piękna"),
    HISTORYCZNA("historyczna"),
    FANTASTYKA_SCIENCE_FICTION("fantastyka, science-fiction"),
    PUBLICYSTYKA_BIOGRAFIA("publicystyka, biografia"),
    OBYCZAJOWA_ROMANS("obyczajowa, romans");

    private final String name;
}