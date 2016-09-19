package NonLinearEquationSolver;

/**
 * Created by flmbrk on 06.09.2016.
 */
public class NewtonsMethod{
    private double eps = 10e-5;
    private int iteration=0;

    public double solve(double xn){
        double x1  = xn - equation(xn)/deviriative(xn);
        double x0 = xn;

        while(Math.abs(x0-x1) > eps) {
            x0 = x1;
            x1 = x1 - equation(x1)/deviriative(x1);
        }
        return x1;
    }
    private  double equation(double x){
        return Math.cos(x)-(x*x*x);
    }

    private  double deviriative(double x){
        return -Math.sin(x)-3*x*x;
    }

    private void printIteration(){

    }

}
