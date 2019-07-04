package joop.collections;

import java.util.ArrayList;

public class TenElementsAL<T> {
    private List<T> al = new ArrayList<>();

    public TenElementsAL(ArrayList<T> al) {
        super();
        this.al = al;
    }
    public TenElementsAL() {
        super();
    }

    public ArrayList<T> getAl() {
        return al;
    }

    public void setAl(ArrayList<T> al) {
        this.al = al;
    }

    @Override
    public String toString() {
        return "al=" + al;
    }

    public void tenElAl(T[] arr){
if(arr.length < 10)return;
for(int i = 0;i < 10;i++){
getAl().add(arr[i]);
}
getAl().remove(0);
getAl().remove(0);
getAl().remove(getAl().size() - 1);
        System.out.println(toString());;
    }
}
