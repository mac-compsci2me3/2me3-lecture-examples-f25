package oopPracticeComplete;

abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double area();

    @Override
    public String toString() {
        return name;
    }

    public boolean isSmallerThan(Shape other) {
        return this.area() < other.area();
    }
}
