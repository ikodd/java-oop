package joop.stack;

public class Sphere {
    private double diameter;
    private double weight;

    public Sphere(double diameter, double weight) {
        super();
        this.diameter = diameter;
        this.weight = weight;
    }
    public Sphere() {
        super();
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "diameter=" + diameter +
                ", weight=" + weight +
                '}';
    }
}
