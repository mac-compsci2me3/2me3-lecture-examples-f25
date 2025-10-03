package oopPracticeComplete;

import java.util.List;

class ShapeUtils {
    public static Shape largestArea(List<Shape> shapes) {
        if (shapes.isEmpty()) {
            return null;
        }

        // TODO: finish implementation of return the shape with the largest area
     
        Shape largest = shapes.get(0);
    
        for (Shape shape : shapes) {
            if (largest.isSmallerThan(shape)) {
                largest = shape;
            }
        }
              
        return largest;
    }
}