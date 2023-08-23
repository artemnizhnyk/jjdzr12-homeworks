package com.isa.bootcamp;


import com.isa.bootcamp.entity.*;
import com.isa.bootcamp.enums.BurgerName;
import com.isa.bootcamp.enums.DrinkName;
import com.isa.bootcamp.enums.PizzaSize;
import com.isa.bootcamp.enums.PizzaTypes;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Marcin", "ul. Kuźnicza 10", "123-456-789");
        Client client2 = new Client("Daria", "ul. Piękna 28", "987-654-321");
        Client client3 = new Client("Adam", "ul. Pomorska 1", "111-222-333");

        MenuItem pizza1 = new Pizza( PizzaSize.LARGE, PizzaTypes.PROSCIUTTO);
        MenuItem pizza2 = new Pizza( PizzaSize.SMALL, PizzaTypes.MARGHERITA);
        MenuItem pizza3 = new Pizza( PizzaSize.MIDDLE, PizzaTypes.CAPRICCIOSA);
        MenuItem hamburger = new Burger(BurgerName.HAMBURGER);
        MenuItem cheeseburger = new Burger(BurgerName.CHEESEBURGER);
        MenuItem cola = new Drink(DrinkName.COLA);
        MenuItem juice = new Drink(DrinkName.JUICE);
        MenuItem beer = new Drink(DrinkName.BEER);

        Order order1 = new Order(client1);
        order1.addItem(pizza1);
        order1.addItem(juice);
        order1.addItem(juice);

        Order order2 = new Order(client2);
        order2.addItem(pizza2);
        order2.addItem(pizza3);
        order2.addItem(cola);

        Order order3 = new Order(client3);
        order3.addItem(hamburger);
        order3.addItem(beer);

        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);
        System.out.println(client1.equals(client2));
        System.out.println(client1.equals(client1));
    }
}
