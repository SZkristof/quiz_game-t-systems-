package com.tsystems;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Quiz {
    /*public static ArrayList QuizConstructor(ArrayList<String> rawQuestion){

    }*/
    int score;
    ArrayList question;
    public Quiz(int score, ArrayList<String> question){
        this.score = score;
        this.question = question;
    }
    public static ArrayList QuestionTest(){
        ArrayList<String> rawQuestionRow = new ArrayList<>();
        rawQuestionRow.add("Hány éves a norvég király?");
        rawQuestionRow.add("12");
        rawQuestionRow.add("34");
        rawQuestionRow.add("45");
        rawQuestionRow.add("33");
        rawQuestionRow.add("33");
        return rawQuestionRow;
    }
    public void executeQA(ArrayList<String>Question){
        AskQuestion(Question);
        GetAnswer(Question);
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
