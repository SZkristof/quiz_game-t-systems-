package com.tsystems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Quiz {
    int score;
    ArrayList question;

    public Quiz(int score, ArrayList<String> question){
        this.score = score;
        this.question = question;
    }
    public static ArrayList QuestionTest(){
        ArrayList<String> rawQuestionRow1 = new ArrayList<>();
        rawQuestionRow1.add("Hány éves a norvég király?");
        rawQuestionRow1.add("22");
        rawQuestionRow1.add("64");
        rawQuestionRow1.add("45");
        rawQuestionRow1.add("80");
        rawQuestionRow1.add("80");

        ArrayList<String> rawQuestionRow2 = new ArrayList<>();
        rawQuestionRow2.add("Tudja, mennyit fizet most a Microsoft az etikus hekkereknek?");
        rawQuestionRow2.add("250.000 dollár");
        rawQuestionRow2.add("8 év börtön");
        rawQuestionRow2.add("50 dollár");
        rawQuestionRow2.add("1.000 dollár");
        rawQuestionRow2.add("250.000 dollár");

        ArrayList<ArrayList<String>> questionTable = new ArrayList<ArrayList<String>>(2);
        questionTable.add(rawQuestionRow1);
        questionTable.add(rawQuestionRow2);
        return questionTable;
    }
    public void executeQA(ArrayList<ArrayList<String>>questionTable){
        for (int i=0; i < questionTable.size(); i++) {
            AskQuestion(questionTable.get(i));
            GetAnswer(questionTable.get(i));
        }
    }
    public void AskQuestion(ArrayList<String>Question){
        for (int i = 0; i < Question.size()-1; i++) {
            if (i > 0) {
                System.out.println((i) + ". " + Question.get(i));
            } else {
                System.out.println(Question.get(i));
            }
        }
    }
    public void GetAnswer(ArrayList<String>Question){
        Scanner in = new Scanner(System.in);
        int rightOne = Question.indexOf(Question.get(5));
        int userAnswer = in.nextInt();
        System.out.println("userAnswer is " + userAnswer+ "." + "The right answer is " + rightOne + ".");
        if (rightOne == userAnswer) {
            System.out.println("Match!");
            this.score += 1;
            System.out.println(score);
        } else {
            System.out.println("Nope.");
        }
    }
}
