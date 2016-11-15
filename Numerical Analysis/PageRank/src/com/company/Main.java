package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
       int nodes = sc.nextInt();
        int edges = sc.nextInt();
        final int iterations = 20;
        PageRank pr = new PageRank(nodes,edges,iterations);
        System.out.println("Matrix:");
        pr.printMatrix();
        System.out.println("----------------------------------");
        System.out.println("Calculations:");
        pr.compute();
        System.out.println("----------------------------------");
        System.out.println("Result:");
        pr.printEigenVector();
        //лагранжа, ньютона, матрица н на н, кубичній сплайн
    }
}




