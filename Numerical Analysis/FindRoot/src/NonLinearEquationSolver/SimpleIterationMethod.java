package NonLinearEquationSolver;

/**
 * Created by flmbrk on 06.09.2016.
 */
public class SimpleIterationMethod  {
    private double eps = 10e-7;
    private int maxIterations = 25;
    private int iterations=1;

    public double solve(double x){
        double xi=x-lambda(x)*equation(x);
        double x0=x;
        while(iterations<=maxIterations){
            x0=xi;
            xi=xi-lambda(x0)*equation(x0);
            iterations++;
            if(Math.abs(x0-xi)<eps)
                break;
            printIteration(iterations,xi);
            System.out.println(equation(xi));
        }
        System.out.println("*****************");
        printIteration(iterations,xi);
        return xi;
    }

    private void printIteration(int i, double x){
        System.out.println("Iteration number: " + i);
        System.out.println("Root obtained: " + x);
    }

    private static double equation(double x){
        return Math.sin(x)-Math.cos(x);
    }

    private static double lambda(double x){
        return 0.5;
    }

}
