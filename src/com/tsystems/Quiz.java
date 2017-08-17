package com.tsystems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;


public class Quiz {
    int score;
    ArrayList question;

    public Quiz(int score, ArrayList<String> question){
        this.score = score;
        this.question = question;
    }

    /*
    public static ArrayList QuestionTest(){
        //for test reasons, please delete before product release
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
    */
    public void executeQA(ArrayList<ArrayList<String>>questionTable){
        for (int i=0; i < questionTable.size(); i++) {
            GetAnswer(questionTable.get(i));
        }
    }

    public int AskQuestion(ArrayList<String>Question){
        /* We should randomize this one. */
        Object[] options = {Question.get(1),Question.get(3),Question.get(2),Question.get(4)};
        ArrayList<String> answers=  new ArrayList<>();
        answers.add("első");
        answers.add("els");
        answers.add("el");
        Collections.shuffle(answers);
        System.out.println(answers);
        int answer = JOptionPane.showOptionDialog(null,
                Question.get(0),
                "Quiz",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        return answer;
    }

    /*
    public static void correctAnswers(){
        csvReader file = new csvReader();
        ArrayList Question = new ArrayList(file.readFile());
        ArrayList<String> rightAnswers = new ArrayList<>();
        for (int i = 0; i < questionTable.size(); i++) {
            questionTable.get(0).
        }
        System.out.println(questionTable);
    }
    */
    public void GetAnswer(ArrayList<String>Question){
        //correctAnswers();
        int userAnswer = AskQuestion(Question)+1;
        int rightOne = Question.indexOf(Question.get(1));
        JOptionPane.showMessageDialog(null, "Your answer is: " + userAnswer +
                "\n"+"The right answer is: " + rightOne);
        if (rightOne == userAnswer) {
            JOptionPane.showMessageDialog(null,"Match!");
            this.score += 1;
            JOptionPane.showMessageDialog(null, "Your score is: " + score);
        } else {
            JOptionPane.showMessageDialog(null, "Nope, wrong answer.");
            JOptionPane.showMessageDialog(null, "Your score is: " + score);
        }
    }
}
