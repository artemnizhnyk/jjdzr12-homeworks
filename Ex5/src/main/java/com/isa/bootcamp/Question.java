package com.isa.bootcamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
    String text;
    Category category;
    Answer[] answers;

    public Question(final String text, final Category category, Answer... answers) {
        this.text = text;
        this.category = category;
        this.answers = answers;
    }
}
