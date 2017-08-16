package com.tsystems;

import java.io.*;
import java.util.*;


public class csvReader {

    private Scanner scanPath;

    public String getPath() {
        String path = "";
        try {
            /* we should make it universal */
            scanPath = new Scanner(new File("csv_path.txt"));
        } catch (Exception e) {
            System.out.println("csv_path.txt was not found...");
        }

        /* For testing reasons it prints out the path to the csv file (the file contains only that) */
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
        ArrayList<ArrayList<String>> questionTable = new ArrayList<ArrayList<String>>();

        while (scannedFile.hasNextLine()){
            String line = scannedFile.nextLine();
            String[] values = line.split(",");
            ArrayList<String> tempQuestion = new ArrayList<>();
            for (int i = 0; i < values.length; i++) {
                if ((i+1)%5 == 0) {
                    tempQuestion.add(values[i-4]);
                    tempQuestion.add(values[i-3]);
                    tempQuestion.add(values[i-2]);
                    tempQuestion.add(values[i-1]);
                    tempQuestion.add(values[i]);
                    questionTable.add(tempQuestion);
                }
            }
        }
    }

    public void closeFile(){
        scannedFile.close();
        scanPath.close();
    }
}