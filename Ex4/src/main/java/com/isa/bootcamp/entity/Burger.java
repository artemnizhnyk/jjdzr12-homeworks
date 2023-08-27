package com.isa.bootcamp.entity;

import com.isa.bootcamp.enums.BurgerName;

public class Burger extends MenuItem {
    private BurgerName burgerType;

    public Burger(BurgerName burgerType) {
        super("Burger");
        this.burgerType = burgerType;
    }
}
