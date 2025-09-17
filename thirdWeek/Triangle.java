package thirdWeek;

public class Triangle {
    protected double a;
    protected double b;
    protected double c;

    public Triangle(double side1, double side2, double side3) {
        this.a = side1;
        this.b = side2;
        this.c = side3;
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    // Method to calculate area (dummy implementation)
    public double area() {
        System.out.println("Anybody know Heron's Formula?");
        return 0;
    }

    public String toString(){
        String str = "This is a triangle with sides: "+this.a +", "+ this.b +", " + this.c +".";
        return str;
    }
}
