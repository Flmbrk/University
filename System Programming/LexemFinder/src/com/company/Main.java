package com.company;

import java.io.IOException;
import java.util.Random;

public class Main {

    public static void reset(){
        System.out.print("\u001B[0m");
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        String[] arr = {"DimaSh", "DimaKd", "Bohdan", "Vlad" };
        int arr1[]= new int[arr.length];
        Random random = new Random();

        for(int i=0;i<arr1.length;i++){
            arr1[i] = random.nextInt(2);
            System.out.println(arr1[i]);
        }

     //   System.out.println("\u001B[36m"+"aabc");
     //   reset();
     //   System.out.println("fdfdf");
     //   System.out.println("\u001B[0m"+"fddssd");

     //   String path = "";
     //   IOService reader = new IOService(path);
        //reader.readFromFile();

    }
}
