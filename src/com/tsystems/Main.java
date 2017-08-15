package com.tsystems;

public class Main {

    public static void main(String[] args) {

        csvReader file = new csvReader();
        file.openFile();
        file.readFile();
        file.closeFile();
    }
}
