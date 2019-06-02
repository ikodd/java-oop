public class Cat {
    String name;
    String sex;
    String breed;
    String fur;
    int age;
    double weight;
    String color;
    boolean chaseMouse;
    Cat(String name,String sex,String breed, String fur, int age, double weight,String color, boolean chaseMouse){
        this.name = name;
        this.sex = sex;
        this.breed = breed;
        this.fur = fur;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.chaseMouse = chaseMouse;
    }

     public void meow(){
         System.out.println("Мяу!");
     }
     public void print(){
         System.out.println("Описание кота:");
         System.out.println("Имя: "+name);
         System.out.println("Пол: "+sex);
         System.out.println("Порода: "+breed);
         System.out.println("Длина шерсти: "+fur);
         System.out.println("Возраст: "+age);
         System.out.println("Вес: "+weight);
         System.out.println("Цвет: "+color);
         System.out.println("Способ"+(sex=="кот"?"ен":"на")+" ловить мышей: "+(chaseMouse?"да":"нет"));
              }
         public void state(){
         int catSt = (int)(Math.round(Math.random()*10));
         String str;
         if(catSt>=0&&catSt<3){
             str = "спит";
         }else if(catSt>=3&&catSt<7){
             str = "играет";
         }else{
             str = "ест";
         }
                  System.out.println("Сейчас "+name+" "+str+"\r\n");
              }

}
