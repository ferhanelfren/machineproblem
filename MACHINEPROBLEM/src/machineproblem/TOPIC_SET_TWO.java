
package machineproblem;


public class TOPIC_SET_TWO {
    
     // Initial guesses
        double x0 = 3.0;
        double x1 = 4.0;
        double tolerance = 0.0001;
        double x2 = 0.0; // To hold the new value of x
        double error;
        
        
    // Define the tolerance level
    static final double TOLERANCE = 0.0001;
        
        
    // Define the function f(x)
    public static double function(double x) {
        return Math.pow(x, 3) - 4 * Math.pow(x, 2) + x - 10;
    }
    
 // Method to perform the Secant Method and display results in a table format
    public void secant() {
        double x2 = 0.0; // To hold the new value of x
        double error;
        
        System.out.println( );
        System.out.println("---------------Secant Method--------------------");
        System.out.println( );
        System.out.println("x0 = " +  3.0 + "; x1 = " + 4.0 + "; tolerance = " + 0.0001);
        System.out.println( );
        // Print table header
        System.out.printf("%-10s %-10s %-10s %-15s %-15s %-15s\n", "x0", "x1", "x2", "f(x0)", "f(x1)", "f(x2)");
        System.out.println("---------------------------------------------------------------");

        // Iterate using the Secant Method
        do {
            double f_x0 = function(x0);
            double f_x1 = function(x1);

            // Calculate x2 using the Secant formula
            x2 = x1 - (f_x1 * (x1 - x0)) / (f_x1 - f_x0);
            double f_x2 = function(x2);

            // Display the values in a row
            System.out.printf("%-10.4f %-10.4f %-10.4f %-15.5f %-15.5f %-15.5f\n", x0, x1, x2, f_x0, f_x1, f_x2);

            // Update x0 and x1 for the next iteration
            x0 = x1;
            x1 = x2;

            // Calculate the absolute error
            error = Math.abs(f_x2);
        } while (error > tolerance);

        System.out.println("---------------------------------------------------------------");
       // System.out.printf("Approximate root found at x = %.4f with absolute error = %.5f\n", x2, error);
    }
    
    // Iterative formulas based on the rearranged equations
    public double calculateX1(double x2, double x3) {
        return (11 + 2 * x2 - x3) / 6;
    }

    public double calculateX2(double x1, double x3) {
        return (5 + 2 * x1 - x3) / 7;
    }

    public double calculateX3(double x1, double x2) {
        return (-1 + x1 + 2 * x2) / 5;
    }
    
        // Gauss-Jacobi Method to solve system of linear equations
    public void gaussJacobiMethod() {
        System.out.println("\n--------------- Gauss-Jacobi Method --------------------");
        System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Iteration", "X1", "X2", "X3", "Error X1", "Error X2", "Error X3");
        System.out.println("--------------------------------------------------------------------------");

        double x1 = 0.0, x2 = 0.0, x3 = 0.0; // Initial guesses
        double prevX1, prevX2, prevX3;
        double error1, error2, error3;
        int iteration = 0;

        // Iterate until the error is within the tolerance for all variables
        do {
            prevX1 = x1;
            prevX2 = x2;
            prevX3 = x3;

            // Calculate new values using the iterative formulas
            x1 = calculateX1(prevX2, prevX3);
            x2 = calculateX2(prevX1, prevX3);
            x3 = calculateX3(prevX1, prevX2);

            // Calculate the errors
            error1 = Math.abs(x1 - prevX1);
            error2 = Math.abs(x2 - prevX2);
            error3 = Math.abs(x3 - prevX3);

            // Print the values for each iteration
            System.out.printf("%-10d %-15.8f %-15.8f %-15.8f %-15.8f %-15.8f %-15.8f\n", iteration, x1, x2, x3, error1, error2, error3);
            iteration++;

        } while (error1 > TOLERANCE || error2 > TOLERANCE || error3 > TOLERANCE);

        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("Solution found: X1 = %.8f, X2 = %.8f, X3 = %.8f\n", x1, x2, x3);
    }
    
    // Newton's Divided Difference Table
    public void newtonDividedDifference() {
        // Define the x and f(x) values (example values from the image)
        double[] x = {-4, -2, -1, 1, 2, 3};
        double[] fx = {-66, -10, -3, -1, 6, 25};

        // Calculate the divided difference table
        double[][] dividedDifferenceTable = calculateDividedDifferenceTable(x, fx);

        // Display the divided difference table
        System.out.println("\n--------------- Newton's Divided Difference Table ----------------");
        for (int i = 0; i < dividedDifferenceTable.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%10.4f ", dividedDifferenceTable[i][j]);
            }
            System.out.println();
        }

        // Example: Interpolate at a specific value, e.g., x = 0.5
        double interpolateAt = 0.5;
        double interpolatedValue = interpolate(x, dividedDifferenceTable, interpolateAt);

        System.out.printf("\nInterpolated value at x = %.2f: %.4f\n", interpolateAt, interpolatedValue);
    }

    // Method to calculate the divided difference table
    private double[][] calculateDividedDifferenceTable(double[] x, double[] fx) {
        int n = x.length;
        double[][] table = new double[n][n];

        // Fill the first column with f(x) values
        for (int i = 0; i < n; i++) {
            table[i][0] = fx[i];
        }

        // Calculate the divided differences
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                table[i][j] = (table[i + 1][j - 1] - table[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        return table;
    }

    // Method to interpolate using Newton's formula
    private double interpolate(double[] x, double[][] table, double value) {
        double result = table[0][0];
        double product = 1;

        for (int i = 1; i < x.length; i++) {
            product *= (value - x[i - 1]);
            result += table[0][i] * product;
        }

        return result;
    }
    
}
