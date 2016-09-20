package com.company;

import NonLinearEquationSolver.BisectionMethod;
import NonLinearEquationSolver.NewtonsMethod;
import NonLinearEquationSolver.SimpleIterationMethod;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Newtons Method:");
        NewtonsMethod nm = new NewtonsMethod();
        System.out.println(nm.solve(0.5));
        System.out.println("Bisection method:");
        BisectionMethod bm = new BisectionMethod();
        System.out.println(bm.solve());
        System.out.println("Simple iteration method");
        SimpleIterationMethod sm = new SimpleIterationMethod();
       System.out.println( sm.solve(-56));
    }






}
