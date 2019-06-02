public class HomeW2905 {
    public static void main(String[] args){
     Cat cat1 = new Cat("Мурзик","мужской", "британская", "короткая", 5,4.5,"пепельный",true);
        Cat cat2 = new Cat("Мурка","женский", "сиамская", "короткая", 3,5,"светло-коричневый",true);
        cat1.print();
cat1.state();
cat2.print();
cat2.state();
cat2.meow();
    }
