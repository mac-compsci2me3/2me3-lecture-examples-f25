package thirdWeek;
 
public class RightTriangle extends Triangle {
    public RightTriangle(double side1, double side2, double side3) {
        super(side1, side2, side3); 

        // cannot put arbitrary code before super (must be the first line)
        // does mean it will create object anyway, can consider using other method for creation if needed
        if (!isRightTriangle()) {
            //IllegalArgumentException class extends RuntimeException, meaning it’s an unchecked exception (the compiler does not force you to declare or catch it).
            // It signals that a method or constructor has been passed an argument that is inappropriate or invalid.
            throw new IllegalArgumentException("The given sides do not form a right triangle.");
        }
    }

    // Floating-point numbers are not exact in Java (e.g., 0.1 + 0.2 != 0.3).
    // Direct equality (a^2 + b^2 == c^2) can fail due to tiny rounding errors.
    // epsilon (e.g., 1e-6) allows “close enough” comparison.
    // Without epsilon, valid right triangles (like 3-4-5) might sometimes fail the check due to floating-point precision.
    private boolean isRightTriangle() {
        double eps = 1e-6; 
        return Math.abs(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) < eps ||
               Math.abs(Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) < eps ||
               Math.abs(Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) < eps;
    }

    public double area() {
        return 0.5 * this.a * this.b; 
    }

    // Main method to test the RightTriangle class
    public static void main(String[] args) {
          try {
        RightTriangle rt = new RightTriangle(3, 4, 6); 
        System.out.println("Area: " + rt.area());
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    }
       
    }
}
