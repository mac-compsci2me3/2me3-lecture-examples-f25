package thirdWeek;

public class EquilateralTriangle extends Triangle {

    public EquilateralTriangle(double side) {
        super(side,side,side); 
    }

    public double area() {
        return 0.5 * this.a * (this.a * (Math.sqrt(3) * 0.5) / 2);
    }

    public static void main(String[] args) {
        EquilateralTriangle eqTriangle = new EquilateralTriangle(5); 
        System.out.println("The area of the equilateral triangle is: " + eqTriangle.area());
    }
}
