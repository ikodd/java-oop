public class Rectangle extends Shape{
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;


    public Rectangle(Point pointA, Point pointB, Point pointC) {
        super();
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public Rectangle(){
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

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", pointD=" + pointD +
                '}';
    }

    @Override
    public  double calcPerim (Rectangle rectangle){
        //Длина стороны по координатам:
        //d = sqrt((x1-x2)^2+(y1-y2)^2), где x1, y1 и x2,y2 – координаты вершин стороны d
        double d1 = Math.sqrt(Math.pow((pointA.getX()-pointB.getX()),2)+
                Math.pow((pointA.getY()-pointB.getY()),2));
        double d2 = Math.sqrt(Math.pow((pointB.getX()-pointC.getX()),2)+
                Math.pow((pointB.getY()-pointC.getY()),2));
        return 2*(d1 + d2);
    }

    @Override
    public double calcArea(Rectangle rectangle){
//Площадь прямоугольника: S = d1*d2
        double d1 = Math.sqrt(Math.pow((pointA.getX()-pointB.getX()),2)+
                Math.pow((pointA.getY()-pointB.getY()),2));
        double d2 = Math.sqrt(Math.pow((pointB.getX()-pointC.getX()),2)+
                Math.pow((pointB.getY()-pointC.getY()),2));
        return d1*d2;
    }
}
