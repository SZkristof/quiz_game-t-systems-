package com.tsystems;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        csvReader file = new csvReader();
        ArrayList questionTable = new ArrayList(file.readFile());
        int score = 0;
        Quiz quiz = new Quiz(score, questionTable);
        quiz.executeQA(questionTable);
    }
}
