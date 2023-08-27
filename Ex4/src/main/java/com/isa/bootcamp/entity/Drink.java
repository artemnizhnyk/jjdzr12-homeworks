package com.isa.bootcamp.entity;

import com.isa.bootcamp.enums.DrinkName;

public class Drink extends MenuItem {

    private DrinkName drinkType;

    public Drink(DrinkName drinkType) {
        super("Drink");
        this.drinkType = drinkType;
    }

    public DrinkName getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkName drinkType) {
        this.drinkType = drinkType;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkType=" + drinkType +
                '}';
    }
}
