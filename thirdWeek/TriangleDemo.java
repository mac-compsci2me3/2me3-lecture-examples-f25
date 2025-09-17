package thirdWeek;

public class TriangleDemo {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3,4,5);

        System.out.println(triangle.toString());
        System.out.println("Perimeter: " + triangle.perimeter());
        System.out.println("Area: " + triangle.area());

        //
        RightTriangle triangle2 = new RightTriangle(3,4,5);

        System.out.println("Perimeter: " + triangle2.perimeter());
        System.out.println("Area: " + triangle2.area());
    }
}
