package com.isa.bootcamp;

import java.util.*;

public class Quiz {
    private static QuestionPool questionPool = QuestionPool.getInstance();
    private static int score;

    public static void start() {
        score = 0;
        Collections.shuffle(questionPool.questions());

        for (int i = 0; i <= 2; i++) {
            Question question = questionPool.questions().get(i);
            System.out.println("Pytanie nr: " + (i + 1));
            System.out.println("Kategoria: " + question.getCategory());
            System.out.println("Treść pytania: " + question.getText());

            List<Answer> answers = Arrays.asList(question.getAnswers());
            Collections.shuffle(answers);

            for (int j = 0; j < answers.size(); j++) {
                System.out.println((char) ('a' + j) + ". " + answers.get(j).getText());
            }

            char userAnswer = getUserAnswer();

            Answer selectedAnswer = answers.get(userAnswer - 'a');
            if (selectedAnswer.isCorrect()) {
                System.out.println("Poprawna odpowiedź!\n");
                score++;
            } else {
                System.out.println("Niepoprawna odpowiedź. Poprawna odpowiedź to: " +
                        getCorrectAnswer(answers) + "\n");
            }

        }


        System.out.println("Twój wynik: " + score + "/" + 3);
    }

    private static char getUserAnswer() {
        System.out.print("Podaj odpowiedź (a, b, lub c): ");
        Scanner scanner = new Scanner(System.in);
        char userAnswer = scanner.next().charAt(0);
        if (!(userAnswer - 'a' >= 0 && userAnswer - 'a' <= 2)) {
            System.out.println("Wprowadziłeś coś źle, podaj literę - a, b lub c");
            userAnswer = getUserAnswer();
        }
        return userAnswer;
    }

    private static char getCorrectAnswer(List<Answer> answers) {
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).isCorrect()) {
                return (char) ('a' + i);
            }
        }
        return ' ';
    }
}
