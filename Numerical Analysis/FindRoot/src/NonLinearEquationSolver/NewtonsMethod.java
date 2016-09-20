package NonLinearEquationSolver;

/**
 * Created by flmbrk on 06.09.2016.
 */
public class NewtonsMethod{
    private double eps = 10e-5;
    private int iteration=1;

    public double solve(double xn){
        double x1  = xn - equation(xn)/derivative(xn);
        double x0 = xn;

        while(Math.abs(x0-x1) > eps) {
            x0 = x1;
            x1 = x1 - equation(x1)/derivative(x1);
            iteration++;
            printIteration(iteration,x1);
            System.out.println(equation(x1));
        }
        System.out.println("*****************");
        printIteration(iteration,x1);
        return x1;
    }
    private  static double equation(double x){
        return Math.cos(x)-(x*x*x);
    }

    private  static double derivative(double x){
        return -Math.sin(x)-3*x*x;
    }

    private void printIteration(int i,double x){
        System.out.println("Iteration number: " + i);
        System.out.println("Root obtained: " + x);
    }

}
