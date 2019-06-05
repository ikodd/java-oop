public class Circle extends Shape{
    private Point pointA;
    private Point pointB;

    public Circle(Point pointA, Point pointB) {
        super();
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Circle(){
        super();
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                '}';
    }

    public double calcPerim(Circle circle){
        //P = 2PI*r, r = d/2
        double d = Math.sqrt(Math.pow((pointA.getX()-pointB.getX()),2)+
                Math.pow((pointA.getY()-pointB.getY()),2));
        return 2*Math.PI*(d/2);
    }

    public double calcArea(Circle circle){
     //S = PI*r^2
     double d = Math.sqrt(Math.pow((pointA.getX() - pointB.getX()),2)+
             Math.pow((pointA.getY() - pointB.getY()),2));
     return Math.PI*(Math.pow((d/2),2));
    }
}
