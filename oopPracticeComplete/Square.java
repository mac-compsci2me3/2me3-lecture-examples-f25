package oopPracticeComplete;

class Square extends Shape {
    private double side;

    public Square(double side) {
        super("Square");
        this.side = side;
    }

    // TODO: implementing the area method
    @Override
    public double area() {
        return side * side;
    }
}
