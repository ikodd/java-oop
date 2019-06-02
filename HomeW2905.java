import java.util.Scanner;
public class HomeW2905 {
    public static void main(String[] args){
        Cat cat1 = new Cat("Мурзик","кот", "британская", "короткая", 5,4.5,"пепельный",true);
        Cat cat2 = new Cat("Мурка","кошка", "сиамская", "короткая", 3,5,"светло-коричневый",true);
        cat1.print();
cat1.state();
cat2.print();
cat2.state();
cat2.meow();

//Конструктор: инициализация tri1
Triangle tri1 = new Triangle("Треугольник №1",5,6,4);
Triangle tri2 = new Triangle("Треугольник №2",12,6,7);
                    tri1.info();
//Вычисление площади
        if(validTri(tri1.getSideA(),tri1.getSideB(),tri1.getSideC())){
            System.out.println("Площадь, "+ tri1.getNameT()+": "+areaTri(tri1.getSideA(),tri1.getSideB(),tri1.getSideC()));
                    }
        tri2.info();
        if(validTri(tri2.getSideA(),tri2.getSideB(),tri2.getSideC())){
            System.out.println("Площадь, "+ tri2.getNameT()+": "+areaTri(tri2.getSideA(),tri2.getSideB(),tri2.getSideC()));
                  }
                     //Меняем длины сторон треугольника (tri1)
        tri1.setSideA(2);
        tri1.setSideB(4);
        tri1.setSideC(7);
        tri1.info();
        System.out.println(tri1.getNameT()+" со сторонами "
                +tri1.getSideA()+", "+tri1.getSideB()+", "
                +tri1.getSideC()
                +(validTri(tri1.getSideA(),tri1.getSideB(),tri1.getSideC())?" может быть построен.":" построить не возможно."));
        //Попробуем вычислить его площадь
           areaTri(tri1.getSideA(),tri1.getSideB(),tri1.getSideC());
            }



    //П/п: вычисление площади треугольника
    public static double areaTri(double a,double b, double c){
double p = (a+b+c)/2;
       return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

   //П/п: проверка; если любая пара сторон больше третьей, треугольник может быть построен
    public static boolean validTri(double a, double b, double c){
     return a + b > c && b + c > a && a + c > b;
    }

}
