package com.isa.bootcamp.entity;

import com.isa.bootcamp.enums.PizzaSize;
import com.isa.bootcamp.enums.PizzaTypes;

public class Pizza extends MenuItem {
    private PizzaSize size;
    private PizzaTypes type;

    public Pizza(PizzaSize size, PizzaTypes type) {
        super("Pizza");
        this.size = size;
        this.type = type;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public PizzaTypes getType() {
        return type;
    }

    public void setType(PizzaTypes type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
