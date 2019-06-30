package joop.stack;

public class Box {
    private double width;
    private double length;
    private double height;
    private double weight;

    public Box(double width, double length, double height, double weight) {
        super();
        this.width = width;
        this.length = length;
        this.height = height;
        this.weight = weight;
    }
    public Box() {
        super();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", length=" + length +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
