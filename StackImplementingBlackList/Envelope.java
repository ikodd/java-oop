package joop.stack;

public class Envelope {
    private double height;
    private double width;
    private double weight;

    public Envelope(double height, double width, double weight) {
        super();
        this.height = height;
        this.width = width;
        this.weight = weight;
    }
    public Envelope() {
        super();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "height=" + height +
                ", width=" + width +
                ", weight=" + weight +
                '}';
    }
}
