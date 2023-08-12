package com.isa.generator;

import java.util.Scanner;

public class NumbersConstraints {
    private int numberFrom;
    private int numberTo;
    private int countOfNumbers;


    public void setNumbersConstraints() {
        setNumbersFrom();
        setNumbersTo();
        setCountOfNumbers();
    }

    private void setNumbersFrom() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Podaj dolny zakres, od którego mam losować: ");
            try {
                numberFrom = scanner.nextInt();
                if (numberFrom < 0) {
                    System.out.println("Dolny zakres ma być wyższy od zera, spróbuj jeszcze raz.");
                    setNumbersFrom();
                }
                break;
            } catch (Exception e) {
                System.out.println("Wprowadziłeś coś źle, spróbuj jeszcze raz.");
                setNumbersFrom();
                break;
            }
        }
    }

    private void setNumbersTo() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Podaj górny zakres, do którego mam losować: ");
            try {
                numberTo = scanner.nextInt();
                if (numberTo < numberFrom) {
                    System.out.println("Górny zakres nie może być mniejszy od dolnego, podaj liczbę większą od " +
                            numberFrom + ". Spróbuj jeszcze raz");
                    setNumbersTo();
                }
                break;
            } catch (Exception e) {
                System.out.println("Wprowadziłeś coś źle, spróbuj jeszcze raz.");
                setNumbersTo();
                break;
            }
        }
    }

    private void setCountOfNumbers() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Podaj ile liczb mam wylosować: ");
            try {
                countOfNumbers = scanner.nextInt();
                if (countOfNumbers <= 0) {
                    System.out.println("Ilość liczb do wylosowania ma byc wieksza od zera, podaj inną liczbę");
                    setCountOfNumbers();
                }
                if (numberTo - numberFrom < countOfNumbers) {
                    System.out.println("Ilość liczb do wylosowania ma być nie więsza od " + (numberTo - numberFrom) +
                            ". Inaczej liczby mogą sie powtórzyć. Spróbuj jeszcze raz.");
                    setCountOfNumbers();
                }
                break;
            } catch (Exception e) {
                System.out.println("Wprowadziłeś coś źle, spróbuj jeszcze raz");
                setCountOfNumbers();
                break;
            }
        }

    }

    public int getNumberFrom() {
        return numberFrom;
    }

    public int getNumberTo() {
        return numberTo;
    }

    public int getCountOfNumbers() {
        return countOfNumbers;
    }

    @Override
    public String toString() {
        return "NumbersConstraints{" +
                "numbersFrom=" + numberFrom +
                ", numbersTo=" + numberTo +
                ", countOfNumbers=" + countOfNumbers +
                '}';
    }
}
