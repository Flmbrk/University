package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Bogdan on 14.11.2016.
 */
public class PageRank {

    class Matrix {
        private int n;
        private int e;
        private int[][] counts;
        private int[] outDegree;

        public Matrix(int n, int e) {
            this.n = n;
            this.e = e;
            counts = new int[n][n];
            outDegree = new int[n];
            read();
        }


        public void read() {
            Scanner sc = new Scanner(System.in);

            for (int k = 0; k < e; k++) {
                int i = sc.nextInt();
                int j = sc.nextInt();
                outDegree[i]++;
                counts[i][j]++;
            }
        }

        // Print probability distribution for row i.
        public double[][] makeStochastic() {
            double result[][] = new double[n][n];
            for (int i = 0; i < n; i++) {


                for (int j = 0; j < n; j++) {
                    result[i][j] = 0.90 * counts[i][j] / outDegree[i] + 0.10 / n;
                }

            }
            return result;
        }
    }
    private double matrix[][];
    private double eigenvector[];
    private int nodes;
    private int edges;
    private int iterations;

    public PageRank(int nodes,int edges,int iterations){
        this.nodes = nodes;
        this.edges = edges;
        this.iterations = iterations;
        this.eigenvector = new double[nodes];
        eigenvector[0] = 1.0;
        Matrix temp = new Matrix(nodes,edges);
        this.matrix = temp.makeStochastic();
    }

    public void compute(){

        for (int t = 0; t < iterations; t++) {

            // Compute effect of next move on page ranks.
            double[] newVector = new double[nodes];
            for (int j = 0; j < nodes; j++) {
                //  New rank of page j is dot product of old ranks and column j of p[][].
                for (int k = 0; k < nodes; k++)
                    newVector[j] += eigenvector[k]*matrix[k][j];
            }

            // Update page ranks.
            eigenvector = newVector;
            System.out.println("Eigenvector on iteration number "+(t+1)+":");
            printEigenVector();
        }



    }

    public void printMatrix(){
        for(int i=0;i<nodes;i++){
            for(int j=0;j<nodes;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }

    public void printEigenVector(){
        for(double x : eigenvector)
            System.out.print(x+" ");
        System.out.println();
    }







}
