package joop.stack;

import java.util.Arrays;
/*
*   Стек с реализацией "черного списка"
*/

public class StackOb implements BlackListing {
    private Object[]arrOb = new Object[4]; //Количество ячеек в стеке
    private BlackList bl; // "Черный список" с недопустимыми для добавления в стек классами

    public StackOb(Object[] arrOb, BlackList bl) {
        super();
        this.arrOb = arrOb;
        this.bl = bl;
    }

    public StackOb(BlackList bl){
      super();
      this.arrOb = arrOb;
      this.bl = bl;
    }

    public StackOb(){
        super();
    }

    public Object[] getArrOb() {
        return arrOb;
    }

    public void setArrOb(Object[] arrOb) {
        this.arrOb = arrOb;
    }

    public BlackList getBl() {
        return bl;
    }

    public void setBl(BlackList bl) {
        this.bl = bl;
    }

    @Override
    public String toString() {
        return "StackOb{" +
                "arrOb=" + Arrays.toString(arrOb) +
                '}';
    }

    /*
    *    Метод: добавление элемента в стек
   */
    public void push(Object o){
        int addrNull = checkNull();
        Class oClass = o.getClass();
        if(getBl().getBlackList() != null && getBl().searchBClass(oClass)){
            System.out.println("Класс " + oClass + " в \"черном списке\"" + ". Поместить объект этого класса в стек не возможно");
            return;
        }
        if(addrNull == -1){
    System.out.println("Стек заполнен. Поместить  " + o + " не возможно");
    return;
}
Object[] arrTmp = getArrOb();
arrTmp[addrNull] = o;
setArrOb(arrTmp);
    }
/*
*     Метод: получение "верхнего" элемента стека с удалением
*/
    public Object pop(){
        int addrNull = checkNull();
        Object oResult = null;
        Object[] arrTmp = new Object[getArrOb().length];
        if(addrNull == 0){
            System.out.println("Стек  не заполнен");
            return oResult;
        }
        if(addrNull == -1){
            System.arraycopy(getArrOb(),0,arrTmp,0,getArrOb().length - 1);
            oResult = getArrOb()[getArrOb().length - 1];
        }
        if(addrNull > 0){
            System.arraycopy(getArrOb(),0,arrTmp,0,addrNull - 1);
            oResult = getArrOb()[addrNull - 1];
        }
        setArrOb(arrTmp);
        return oResult;
    }
    /*
    *    Метод: получение "верхнего" элемента стека без его удаления
    */
    public Object peek(){
        int addrNull = checkNull();
        if(addrNull == -1)return getArrOb()[getArrOb().length - 1];
        if(addrNull != 0)return getArrOb()[addrNull - 1];
        System.out.println("Стек не заполнен");
        return null;
    }
/*
 *  Метод: поиск null в стеке
 * Используется для определения последнего добавленного в стек элемента
*/
    public int checkNull(){
        if(getArrOb() == null)return 0;
for(int i = 0;i < getArrOb().length;i++){
    if(getArrOb()[i] == null)return i;
}
return -1;
    }

    public void printStack(){
        int i = 1;
        for(Object element : getArrOb()){
            System.out.println((i++) + " " + element);
        }
    }
}
