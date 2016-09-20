package NonLinearEquationSolver;

/**
 * Created by flmbrk on 06.09.2016.
 */
public class BisectionMethod {
    private double eps = 10e-4;
    private int iterations = 0;
    private int MaxIterations = 20;
    private double left = -5;
    private double right = 5;

    private static double equation(double x) {
        return (x*x*x)+3*(x*x)+12*x+8;
    }

    public double solve() {
        double x=0;
        double dx = right - left;

        while (Math.abs(dx) > eps && iterations < MaxIterations && equation(x) != 0) {
            x = ((left + right) / 2);
            if ((equation(left) * equation(x)) < 0) {
                right = x;
                dx = right - left;
            } else {
                left = x;
                dx = right - left;
            }
            iterations++;

            printIteration(iterations,x,dx);
        }
        System.out.println("**********************************");
        printIteration(iterations,x,dx);
        return x;
    }

    void printIteration(int i, double x, double dx){
        System.out.println("Iteration number: " + i);
        System.out.println("Root obtained: " + x);
        System.out.println("Estimated error: " + dx);
    }

    }



