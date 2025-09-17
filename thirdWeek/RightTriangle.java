package thirdWeek;

public class RightTriangle extends Triangle {
    public RightTriangle(double side1, double side2, double side3) {
        super(side1, side2, side3); 
        // if (!isRightTriangle()) {
        //     throw new IllegalArgumentException("The given sides do not form a right triangle.");
        // }
    }

    private boolean isRightTriangle() {
        double eps = 1e-6; 
        return Math.abs(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) < eps ||
               Math.abs(Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) < eps ||
               Math.abs(Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) < eps;
    }

    // public double area() {
    //     return 0.5 * this.a * this.b; 
    // }

    // Main method to test the RightTriangle class
    public static void main(String[] args) {
       
    }
}
