package joop.collections;
/*
*   Метод "Двойная кола" для Шелдона и Ко.
*/
import java.util.ArrayDeque;
import java.util.Queue;

public class DoubleCola {


    public static <T> void dblCola(T[] q, int num){
        Queue<T> queue = new ArrayDeque<>();
        for(T member : q){
          queue.offer(member);
        }
     T element;
     for(int i = 1;i <= num;i++){
         element = queue.remove();
         queue.offer(element);
         queue.offer(element);
     }
        for(T member : queue){
            System.out.println(member);
        }
    }
}
