package com.tsystems;

import java.io.*;
import java.util.*;


public class csvReader {

    private Scanner scanPath;

    public String getPath() {
        String path = "";
        try {
            scanPath = new Scanner(new File("/home/kristof/IdeaProjects/quiz_game-t-systems-/src/csv_path.txt"));
        } catch (Exception e) {
            System.out.println("csv_path.txt was not found...");
        }

        while (scanPath.hasNextLine()) {
            path += scanPath.nextLine();
            System.out.println(path);


        }
        return path;
    }

    private Scanner scannedFile;

    public void openFile() {
        try {
            scannedFile = new Scanner(new File(getPath()));
        } catch (Exception e) {
            System.out.println("could not find file..");
        }
    }

    public void readFile(){
        List<List<String>> lines = new ArrayList<>();
        while (scannedFile.hasNextLine()){
            String line= scannedFile.nextLine();
            String[] values = line.split(",");
            // this adds the currently parsed line to the 2-dimensional string array
            lines.add(Arrays.asList(values));
        }
        String a = lines.get(1).get(0);
        System.out.println(lines);
    }

    public void closeFile(){
        scannedFile.close();
        scanPath.close();
    }
}







/*
         public static void main(String[] args) {
        String testFile = "/home/kristof/IdeaProjects/quiz_game-t-systems-/src/test.csv";
        File fileName = new File(testFile);


        //two dimensional arrayList
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;

        try{
            inputStream = new Scanner(fileName);

            while(inputStream.hasNextLine()){
                String line= inputStream.nextLine();
                String[] values = line.split(",");
                // this adds the currently parsed line to the 2-dimensional string array
                lines.add(Arrays.asList(values));
            }
            /*for (List<String> line: lines) {
                while(inputStream.hasNext(",")){
                    String until = inputStream.next(",");
                    String[] value = until.split(",");
                    line;
                }

                for (String value: line) {


                }

            }
            inputStream.close();
        }catch (FileNotFoundException e) {
            System.err.println("csv file not found");
        }
    */