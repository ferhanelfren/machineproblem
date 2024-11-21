
package machineproblem;


public class TRAPEZOIDAL_RULE {
       // Function to compute f(x)
    public static double functionOne(double x) {
        return 0.2 + 25 * x - 200 * Math.pow(x, 2) + 675 * Math.pow(x, 3)
                - 900 * Math.pow(x, 4) + 400 * Math.pow(x, 5);
    }
    

    // Function to implement the Trapezoidal Rule and display results in a table
    public static double trapezoidalRule(double a, double b, int n) {
        double h = (b - a) / n;  // Step size
        double sum = 0.5 * (functionOne(a) + functionOne(b));  // First and last terms
        double weightedSum = functionOne(a) + functionOne(b);  // For summing f(x) * weight

        // Header for the table
        System.out.printf("%-10s %-15s %-10s %-15s\n", "x", "f(x)", "Weight", "f(x)*Weight");
        System.out.println("----------------------------------------------------------");

        // Display first value at x = a
        System.out.printf("%-10.4f %-15.8f %-10d %-15.8f\n", a, functionOne(a), 1, functionOne(a));

        // Compute the sum of areas and print the intermediate values
        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            double fxi = functionOne(xi);
            sum += fxi;
            double weightedValue = fxi * 2; // Weight is 2 for intermediate points
            weightedSum += weightedValue;
            System.out.printf("%-10.4f %-15.8f %-10d %-15.8f\n", xi, fxi, 2, weightedValue);
        }

        // Display last value at x = b
        System.out.printf("%-10.4f %-15.8f %-10d %-15.8f\n", b, functionOne(b), 1, functionOne(b));
        System.out.println("----------------------------------------------------------");

        // Display the sum of all f(x) * Weight values
        System.out.printf("%-35s %-15.8f\n", "Summation of f(x)*Weight:", weightedSum);

        // Return the estimated integral
        return h * sum;  // Multiply the sum by the step size
    }
    
    
}


//-0.1x^4 - 0.15x^3-0.5x^2-0.25x+1.2
