package oopPracticeComplete;

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    // TODO: implementing the area method
    @Override
    public double area() {
        return length * width;
    }
}