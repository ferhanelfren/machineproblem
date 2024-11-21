
package machineproblem;

import java.util.Scanner;


public class MACHINEPROBLEM {


    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        TOPIC_SET_TWO topic_set_two = new TOPIC_SET_TWO();
        int choices=0;
        double xi = 0.5;
        double h1 = 0.5;
        double h2 = 0.25;
        
        System.out.println("Machine Problem:");
        System.out.println("1. Secant Method");
        System.out.println("2. Gauss Jabcobi Method");
        System.out.println("3. Newton's Interpolation Method");
        System.out.println("4. Trapezoidal Rule");
        System.out.println("5. Centered Finite Divided Difference");
        
        choices = scn.nextInt();
        
        switch (choices) {
            case 1:
                topic_set_two.secant();
                break;
            case 2:

                // Execute Gauss-Jacobi Method to solve the system of equations
                topic_set_two.gaussJacobiMethod();
                break;
            case 3:

                topic_set_two.newtonDividedDifference();
                break;
            case 4:
                TRAPEZOIDAL_RULE trapezoidal_rule = new TRAPEZOIDAL_RULE();
                double low, upper;
                int segments;
                
                System.out.println("TRAPEZOIDAL RULE PROBLEM:");
                System.out.println( );
                
                System.out.println("Input the LOWER Limit (a):");
                low = scn.nextDouble();
                System.out.println();

                System.out.println("Input the UPPER Limit (b):");
                upper = scn.nextDouble();
                System.out.println();

                System.out.println("Input the number of segments:");
                segments = scn.nextInt();
                System.out.println();
                
                
                System.out.println("Lower: " + low + "\nUpper: " + upper + "\nSegments: " + segments);
                System.out.println("Equation: f(x) = 0.2 + 25x - 200x^2 + 675x^3 - 900x^4 + 400x^5");
                System.out.println();

                // Compute the integral using the trapezoidal rule and display results
                double result = trapezoidal_rule.trapezoidalRule(low, upper, segments);
                System.out.println("Estimated integral: " + result);

                break;
            case 5:
                CENTERED_FINITE cf =new CENTERED_FINITE();

                 // Truncated formula
                System.out.println("### Truncated Formula Calculation ###");
                System.out.println( );
                System.out.println("For h="+ h1);
                cf.centeredFiniteDifferenceFirstStepSize(xi, h1);
                System.out.println( );
                System.out.println( );
                System.out.println("For h="+ h2);
                cf.centeredFiniteDifferenceFirstStepSize(xi, h2);
                System.out.println( );
                System.out.println("Derivatived of a function: "+ cf.derivativeFunciton(xi));
                System.out.println("--------------------------------------------------------------------");


                // More accurate formula using xi+2 and xi-2
                System.out.println("\n### More Accurate Formula Calculation ###");
                System.out.println( );
                System.out.println("For h="+ h1);
                cf.moreAccurateCenteredDifferenceFirstStepSize(xi, h1);
                System.out.println( );
                System.out.println("For h="+ h2);
                cf.moreAccurateCenteredDifferenceSecondStepSize(xi, h2);
                System.out.println("Derivatived of a function: "+ cf.derivativeFunciton(xi));
                System.out.println("--------------------------------------------------------------------");
                
                System.out.println("\n### Richardson's Extrapolation Calculation ###");
                System.out.println( );
                cf.richardsonsExtrapolation(xi, h1);
                System.out.println( );
                System.out.println("--------------------------------------------------------------------");
                break;
            default:
                throw new AssertionError();
        }
        
        
    }
    
}
