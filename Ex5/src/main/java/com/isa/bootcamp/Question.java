package com.isa.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
