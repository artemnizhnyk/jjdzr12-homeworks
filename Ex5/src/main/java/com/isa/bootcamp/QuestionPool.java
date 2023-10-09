package com.isa.bootcamp;

import java.util.ArrayList;
import java.util.List;


public class QuestionPool {
    private static final QuestionPool INSTANCE = new QuestionPool();
    private static List<Question> questions;

    private QuestionPool() {
        questions = new ArrayList<>();

        questions.add(new Question("Jakie jest imię jednego z bohaterów w grze Dota 2, który potrafi klonować się?", Category.DOTA2,
                new Answer(" Terrorblade", false),
                new Answer(" Meepo", true),
                new Answer(" Juggernaut", false)));
        questions.add(new Question("Który bohater w grze Dota 2 jest znany z umiejętności \"Black Hole\"?", Category.DOTA2,
                new Answer(" Enigma", true),
                new Answer(" Anti-Mage", false),
                new Answer(" Pudge", false)));

        questions.add(new Question("Która mapa w CS:GO jest znany z charakterystycznego mostu?", Category.CSGO,
                new Answer(" Dust2", false),
                new Answer(" Mirage", false),
                new Answer(" Cobblestone", true)));
        questions.add(new Question("Jaki jest najbardziej popularny tryb rozgrywki w CS:GO, w którym drużyny walczą" +
                " o rozbrojenie lub postawienie bomby?", Category.CSGO,
                new Answer(" Deathmatch", false),
                new Answer(" Arms Race", false),
                new Answer(" Competitive", true)));

        questions.add(new Question("W jakim kraju odbywa się większość rozgrywek w grze PUBG?", Category.PUBG,
                new Answer(" Stanach Zjednoczonych", true),
                new Answer(" Rosji", false),
                new Answer(" Indiach", false)));
        questions.add(new Question("Jak nazywa się najpopularniejsza mapa w grze PUBG?", Category.PUBG,
                new Answer(" Erangel", true),
                new Answer(" Miramar", false),
                new Answer(" Vikendi", false)));
    }

    public List<Question> questions() {
        return questions;
    }

    public static QuestionPool getInstance() {
        return INSTANCE;
    }
}
