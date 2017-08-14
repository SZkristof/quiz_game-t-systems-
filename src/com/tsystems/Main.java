package com.tsystems;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList question = new ArrayList(Quiz.QuestionTest());
        int score = 0;
        Quiz quiz = new Quiz(score, question);
        quiz.executeQA(question);
    }
}
