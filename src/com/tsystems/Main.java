package com.tsystems;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        csvReader file = new csvReader();
        file.openFile();
        file.readFile();
        file.closeFile();

        ArrayList questionTable = new ArrayList(Quiz.QuestionTest());
        int score = 0;
        Quiz quiz = new Quiz(score, questionTable);
        quiz.executeQA(questionTable);
    }
}
