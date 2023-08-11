package com.isa.generator;

public class NumbersGenerator {
    private static NumbersConstraints constraints = new NumbersConstraints();

    public static void generateRandomInts() {

        constraints.setNumbersConstraints();

        System.out.println("Rozpoczynam losowanie " +
                constraints.getCountOfNumbers() + " liczb z zakresu " +
                constraints.getNumberFrom() + " - " +
                constraints.getNumberTo());
        System.out.println("Wylosowane liczby: ");

        for (int i = 0; i < constraints.getCountOfNumbers(); i++) {
            int randomInt = (int) (Math.random() * (constraints.getNumberFrom() + constraints.getNumberTo()));
            System.out.println(randomInt);
        }
    }


}
