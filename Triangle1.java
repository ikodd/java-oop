public class Triangle1 extends Shape {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle1(Point pointA, Point pointB, Point pointC) {
        super();
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Triangle1(){
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

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public String toString() {
        return "Triangle1{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                '}';
    }
@Override
    public double calcPerim(Triangle1 tri){
        //Длина стороны по координатам:
        //d = sqrt((x1-x2)^2+(y1-y2)^2), где x1, y1 и x2,y2 – координаты вершин стороны d
        double d1 = Math.sqrt(Math.pow((pointA.getX()-pointB.getX()),2)+
                Math.pow((pointA.getY()-pointB.getY()),2));
        double d2 = Math.sqrt(Math.pow((pointB.getX()-pointC.getX()),2)+
                Math.pow((pointB.getY()-pointC.getY()),2));
        double d3 = Math.sqrt(Math.pow((pointC.getX()-pointA.getX()),2)+
                Math.pow((pointC.getY()-pointA.getY()),2));

        return d1 + d2 + d3;
    }

    @Override
    public double calcArea(Triangle1 tri) {
//Площадь треугольника по координатам:
// S = (x1*y2+x2*y3+x3*y1-x2*y1-x3*y2-x1*y3)/2
        return (pointA.getX()*pointB.getY()+pointB.getX()*pointC.getY()+
                pointC.getX()*pointA.getY() - pointB.getX()*pointA.getY() - pointC.getX()*pointB.getY() -
                pointA.getX()*pointC.getY())/2;

    }

}
