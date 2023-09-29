package com.isa.bootcamp;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class QuizTest {

    private Quiz quiz = mock();

    @SneakyThrows
    @Test
    public void testValidInput() {
        String input = "a\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        var getUserAnswer = Quiz.class.getDeclaredMethod("getUserAnswer", null);
        getUserAnswer.setAccessible(true);
        char result = (char) getUserAnswer.invoke(quiz);
        assertEquals('a', result);
    }


}