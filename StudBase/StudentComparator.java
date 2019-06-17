package joop;
import java.util.Comparator;

public class StudentComparator implements Comparator {
    private boolean reverse;
    private int sortPar;

    public StudentComparator(boolean reverse, int sortPar) {
        this.reverse = reverse;
        this.sortPar = sortPar;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public int getSortPar() {
        return sortPar;
    }

    public void setSortPar(int sortPar) {
        this.sortPar = sortPar;
    }


    @Override
    public int compare(Object obj1,Object obj2){
        int result = NullComparator.checkNull(obj1,obj2);
        int order = reverse? -1 : 1;
        if(result != 0){
            Student st1 = (Student)obj1;
            Student st2 = (Student)obj2;
           //Сортировка по фамилии
           if(sortPar == 1){
               return st1.getlName().compareTo(st2.getlName())*order;
           }
           //... по возрасту
           if(sortPar == 2){
               return (st1.getAge() - st2.getAge())*order;
           }
           //... по номеру зачетки
           if(sortPar == 3){
               return (st1.getStudId()-st1.getStudId())*order;
           }
           //... по росту
           if(sortPar == 4){
               return (int)(st1.getHeight() - st2.getHeight())*order;
           }
           //... по весу
           if(sortPar == 5){
               return (int)(st1.getWeight() - st2.getWeight())*order;
           }
        }
        return result;

    }
}
