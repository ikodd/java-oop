public abstract class Shape {
    abstract double calcPerim();
    abstract double calcArea();

    public abstract double calcPerim(double x, double y);

    public abstract double calcArea(double x, double y);

    public abstract double calcPerim(Point pointA, Point pointB, Point pointC);

    public abstract double calcArea(Point pointA, Point pointB, Point pointC);

    public abstract double calcPerim(Point pointA, Point pointB);

    public abstract double calcArea(Point pointA, Point pointB);
}
