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

    /*
        public double solve(double xn) {

            while(iterations<=MaxIterations){
                double mid =(left+right)/2;
                if(equation(mid)==0||(right-left)/2<eps){
                    System.out.println("Root was found on iteration "+iterations);
                    return mid;
                }
                iterations++;
                print(mid);
                if(equation(left)*equation(mid)>0){
                    right=mid;
                }
                else left=mid;
            }
            System.out.println("Root wasn't found");
            return 0;
        }
    */
    private void print(double mid) {
        System.out.println("On iteration " + iterations + " value of function is " + equation(mid));
    }

    private static double equation(double x) {
        return (x*x*x)+3*(x*x)+12*x+8;
    }

    public double solve() {
        double x=0;
        double dx = right - left;
        int k = 0;
        while (Math.abs(dx) > eps && k < 10 && equation(x) != 0) {
            x = ((left + right) / 2);
            if ((equation(left) * equation(x)) < 0) {
                right = x;
                dx = right - left;
            } else {
                left = x;
                dx = right - left;
            }
            k++;
            System.out.println("Iteration number: " + k);
            System.out.println("Root obtained: " + x);
            System.out.println("Estimated error: " + dx);
        }
        System.out.println("*****************");
        System.out.println("Iteration number: " + k);
        System.out.println("Root obtained: " + x);
        System.out.println("Estimated error: " + dx);
        return x;
    }

    }



