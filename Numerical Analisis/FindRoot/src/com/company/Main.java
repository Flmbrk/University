package com.company;

import NonLinearEquationSolver.BisectionMethod;
import NonLinearEquationSolver.NewtonsMethod;

public class Main {

    public static void main(String[] args) {
	// write your code here
        NewtonsMethod nm = new NewtonsMethod();
        System.out.println(nm.solve(0.5));
        BisectionMethod bm = new BisectionMethod();
        System.out.println(bm.solve());
    }






}
