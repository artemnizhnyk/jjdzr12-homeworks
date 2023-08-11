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
                break;
            } catch (Exception e) {
                System.out.println("Wprowadziłeś coś źle, spróbuj jeszcze raz");
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
                    System.out.println("Górny zakres nie może być mniejszy od dolnego, podaj liczbę większą od " + numberFrom);
                    setNumbersTo();
                }
                break;
            } catch (Exception e) {
                System.out.println("Wprowadziłeś coś źle, spróbuj jeszcze raz");
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
                if (numberTo - numberFrom <= countOfNumbers * 10) {
                    Scanner lineScanner = new Scanner(System.in);
                    System.out.println("Info: zbyt mały zakres, liczby mogą się powtórzyć z dużą wiarygodnością\n" +
                            "Jeśli chcesz kontynuować wpisz 'y', jeśli chcesz zacząć od nowa wpisz 'n'");
                    String answer = lineScanner.nextLine();
                    switch (answer) {
                        case "y":
                            break;
                        case "n":
                            setNumbersConstraints();
                        default:
                            System.out.println("Podałeś coś źle, więc jednak sprubuj podać liczby od nowa");
                            setNumbersConstraints();

                    }

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
