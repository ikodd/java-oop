import java.util.Scanner;
public class HomeW2905 {
    public static void main(String[] args){
        //Cat cat1 = new Cat("Мурзик","кот",5,4.5,"пятнистый",true);
        /*cat1.name = "Мурзик";
        cat1.age = 5;
        cat1.weight = 4.5;
        cat1.color = "пятнистый";
        cat1.chaseMouse = true;*/
     //   Cat cat2 = new Cat("Мурка","кошка",3,5,"серый",true);
        /*Cat cat2 = new Cat();
        cat2.name = "Мурка";
        cat2.age = 3;
        cat2.weight = 5;
        cat2.color = "серый";
        cat2.chaseMouse = true;*/


  /*      cat1.print();
cat1.state();
cat2.print();
cat2.state();
cat2.meow();*/

//Конструктор: инициализация tri1
Triangle tri1 = new Triangle(5,6,4);
                    tri1.info();

        System.out.println("Треугольник со сторонами "
                +tri1.getSideA()+", "+tri1.getSideB()+", "
                +tri1.getSideC()+(validTri(tri1.getSideA(),tri1.getSideB(),tri1.getSideC())?" может быть построен.":"построить не возможно."));
//Вычисление площади
              areaTri(tri1.getSideA(),tri1.getSideB(),tri1.getSideC());

              //Меняем длины сторон треугольника (tri1)
        tri1.setSideA(2);
        tri1.setSideB(4);
        tri1.setSideC(7);
        tri1.info();
        System.out.println("Треугольник со сторонами "
                +tri1.getSideA()+", "+tri1.getSideB()+", "
                +tri1.getSideC()
                +(validTri(tri1.getSideA(),tri1.getSideB(),tri1.getSideC())?" может быть построен.":" построить не возможно."));
        //Попробуем вычислить его площадь
           areaTri(tri1.getSideA(),tri1.getSideB(),tri1.getSideC());
            }



    //П/п: вычисление площади треугольника
    public static void areaTri(double a,double b, double c){
//Проверка: можно ли построить треугольник с такими сторонами
        if(!validTri(a, b, c)){
    System.out.println("Невозможно построить треугольник со сторонами: "+"\r\na = "+a+"\r\nb = "+b+"\r\nc = "+c);
return;
}
double p = (a+b+c)/2;
        System.out.println("Площадь треугольника:\r\nS=sqrt(p(p-a)(p-b)(p-c)), p - полупериметр");
        System.out.println(Math.sqrt(p*(p-a)*(p-b)*(p-c)));
    }

   //П/п: проверка; если любая пара сторон больше третьей, треугольник может быть построен
    public static boolean validTri(double a, double b, double c){
     return a + b > c && b + c > a && a + c > b;
    }

}
