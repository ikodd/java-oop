public class HomeW0306 {
    public static void main(String[] args){
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,3);
        Point point3 = new Point (3,3);
        Point point4 = new Point(3,0);


        Triangle1 tri1 = new Triangle1(point1,point2,point3);
        System.out.println("Периметр треугольника1: P = " + tri1.calcPerim());
        System.out.println("Площадь треугольника1: S = "+tri1.calcArea());

        Rectangle rec1 = new Rectangle(point1,point2,point3,point4);
        System.out.println("Периметр прямоугольника1: P = " + rec1.calcPerim());
        System.out.println("Площадь прямоугольника1: S = "+rec1.calcArea());

        Circle cir1 = new Circle(point1,point2);
        System.out.println("Периметр окружности1: P = " + cir1.calcPerim());
        System.out.println("Площадь окружности1: S = "+cir1.calcArea());

    }
}
