
package machineproblem;


public class CENTERED_FINITE {
    // Function to compute f(x)
    public double function(double x) {
        // f(x) = -0.1x^4 - 0.15x^3 - 0.5x^2 - 0.25x + 1.2
        return -0.1 * Math.pow(x, 4) - 0.15 * Math.pow(x, 3) 
                - 0.5 * Math.pow(x, 2) - 0.25 * x + 1.2;
    }
    
    public double derivativeFunciton(double x){
        return -0.4 * Math.pow(x, 3) - 0.45 * Math.pow(x, 2) - x - 0.25;
    }

    // Centered finite divided difference method (truncated formula)
    public double centeredFiniteDifferenceFirstStepSize(double xi, double h) {
        double f_xi_plus_one = xi + 1*h;
        double f_xi_minus_one = xi - 1*h;
        double fxiplus1 = function(f_xi_plus_one); 
        double fximinus1 = function(f_xi_minus_one);
        

        System.out.printf("Xi+1 = %.4f, Xi-1 = %.4f\n", xi + h, xi - h);
       
        System.out.printf("f(xi+1) = %.5f, f(xi-1) = %.5f\n", fxiplus1, fximinus1);
        
        double truncatedResult = (fxiplus1 - fximinus1) / (2 * h);
        
        System.out.printf("Result of Truncated f'(xi) = %.5f\n", truncatedResult);
        
        return truncatedResult;
    }
    
    public double centeredFiniteDifferenceSecondStepSize(double xi, double h) {
        double f_xi_plus_one = xi + 1*h;
        double f_xi_minus_one = xi - 1*h;
        double fxiplus1 = function(f_xi_plus_one); 
        double fximinus1 = function(f_xi_minus_one);
        

        System.out.printf("Xi+1 = %.4f, Xi-1 = %.4f\n", xi + h, xi - h);
       
        System.out.printf("f(xi+1) = %.5f, f(xi-1) = %.5f\n", fxiplus1, fximinus1);
        
        double truncatedResult = (fxiplus1 - fximinus1) / (2 * h);
        
        System.out.printf("Result of Truncated f'(xi) = %.5f\n", truncatedResult);
        
        return truncatedResult;
    }

    // More accurate formula
    public double moreAccurateCenteredDifferenceFirstStepSize(double xi, double h) {

        double f_xi_plus_one = xi + 1*h;
        double f_xi_minus_one = xi - 1*h;
        double f_xi_plus_two = xi + 2*h;
        double f_xi_minus_two = xi - 2*h;
        double fxiplus1 = function(f_xi_plus_one); 
        double fximinus1 = function(f_xi_minus_one);
        double fximinus2 = function(f_xi_minus_two);
        double fxiplus2 = function(f_xi_plus_two); 

        // Print values of xi+2, xi+1, xi-1, xi-2
        System.out.printf("Xi+2 = %.4f, Xi-2 = %.4f\n", f_xi_plus_two, f_xi_minus_two);
        System.out.printf("f(xi+2) = %.5f, f(xi-2) = %.5f\n", fxiplus2, fximinus2);
        
        // More accurate centered finite difference formula
        double moreAccurateResult = (-fxiplus2 + 8 * fxiplus1 - 8 * fximinus1 + fximinus2) / (12 * h);
        
        System.out.printf("Result of More Accurate f'(xi) = %.5f\n", moreAccurateResult);
        
        return moreAccurateResult;
    }
    
    public double moreAccurateCenteredDifferenceSecondStepSize(double xi, double h) {

        double f_xi_plus_one = xi + 1*h;
        double f_xi_minus_one = xi - 1*h;
        double f_xi_plus_two = xi + 2*h;
        double f_xi_minus_two = xi - 2*h;
        double fxiplus1 = function(f_xi_plus_one); 
        double fximinus1 = function(f_xi_minus_one);
        double fximinus2 = function(f_xi_minus_two);
        double fxiplus2 = function(f_xi_plus_two); 

        // Print values of xi+2, xi+1, xi-1, xi-2
        System.out.printf("Xi+2 = %.4f, Xi-2 = %.4f\n", f_xi_plus_two, f_xi_minus_two);
        System.out.printf("f(xi+2) = %.5f, f(xi-2) = %.5f\n", fxiplus2, fximinus2);
        
        // More accurate centered finite difference formula
        double moreAccurateResult = (-fxiplus2 + 8 * fxiplus1 - 8 * fximinus1 + fximinus2) / (12 * h);
        
        System.out.printf("Result of More Accurate f'(xi) = %.5f\n", moreAccurateResult);
        
        return moreAccurateResult;
    }
    
    // Richardson's Extrapolation
    public double richardsonsExtrapolation(double xi, double h) {
        double D1 = centeredFiniteDifferenceFirstStepSize(xi, h);     // h step size
        double D2 = centeredFiniteDifferenceFirstStepSize(xi, h / 2); // h/2 step size

        // Richardson's extrapolation formula: D = D2 + (D2 - D1) / 3
        double richardsonResult = D2 + (D2 - D1) / 3;

        System.out.printf("Richardson's Extrapolation: h = %.4f, h/2 = %.4f\n", h, h / 2);
        System.out.printf("D1 (h) = %.5f, D2 (h/2) = %.5f\n", D1, D2);
        System.out.printf("Result of Richardson's Extrapolation = %.5f\n", richardsonResult);

        return richardsonResult;
    }
    
}
