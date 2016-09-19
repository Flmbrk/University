package com.company;

import Services.FileReaderService;
import Services.FunctionService;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        String path = sc.nextLine();

        FileReaderService reader = new FileReaderService(path);
        try {
            reader.readFromFile();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        Collections.sort(reader.getWords(), Collections.reverseOrder(new FunctionService()));
        reader.printWords();

    }




}
