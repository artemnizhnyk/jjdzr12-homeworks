package com.isa.generator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumbersGenerator {
    private static NumbersConstraints constraints = new NumbersConstraints();
    private static Set<Integer> uniqueNumbers = new HashSet<>();
    private static Random randomizer = new Random();

    public static void generateRandomInts() {

        constraints.setNumbersConstraints();

        System.out.println("Rozpoczynam losowanie " +
                constraints.getCountOfNumbers() + " liczb z zakresu " +
                constraints.getNumberFrom() + " - " +
                constraints.getNumberTo());
        System.out.println("Wylosowane liczby: ");

        while (!(uniqueNumbers.size() == constraints.getCountOfNumbers())) {
            int randomInt = randomizer.nextInt(constraints.getNumberTo() - constraints.getNumberFrom()) + constraints.getNumberFrom();
            uniqueNumbers.add(randomInt);
        }
        uniqueNumbers.forEach(System.out::println);
    }


}
