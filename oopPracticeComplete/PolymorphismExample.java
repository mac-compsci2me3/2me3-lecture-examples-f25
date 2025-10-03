package oopPracticeComplete;

import java.util.List;
import java.util.ArrayList;

public class PolymorphismExample {
    public static void main(String[] args) {
        // Creating instances of shapes
        Square square = new Square(4);
        Rectangle rectangle = new Rectangle(2, 6);
        Circle circle = new Circle(8 / Math.PI);

        // Finding the shape with the largest area
        List<Shape> shapes = new ArrayList<>();
        shapes.add(square);
        shapes.add(rectangle);
        shapes.add(circle);

        Shape largestShape = ShapeUtils.largestArea(shapes);
        System.out.println("Largest shape: " + largestShape + " with area: " + largestShape.area());
    }
}
