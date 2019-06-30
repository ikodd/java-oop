package joop.stack;

import java.util.Arrays;
/*
*   "Черный список" классов
*/
public class BlackList implements BlackListing {
   private Class[] blackList;

    public BlackList(Class[] blackList) {
        super();
        this.blackList = blackList;
    }

    public BlackList() {
        super();
    }

    public Class[] getBlackList() {
        return blackList;
    }

    public void setBlackList(Class[] blackList) {
        this.blackList = blackList;
    }
/*
*   Метод: добавление в "черный список"
*   Если в списке есть null, имя класса вставляется на его место, иначе – в конец списка
*/
public void addToList(Class className){
        int nullAddr = searchNull();
        int listLength = (nullAddr == -1) ? getBlackList().length + 1 : getBlackList().length;
        Class[] blackListCopy = Arrays.copyOf(getBlackList(),listLength);
        if(nullAddr != -1)blackListCopy[nullAddr] = className;
        blackListCopy[blackListCopy.length - 1] = className;
        setBlackList(blackListCopy);
    }
  /*
  * Метод: удаление из "черного списка"
  * На выходе true, если удаление успешно
  */
    public boolean delFromList(Class className){
        int cellAddr = searchName(className);
        if(cellAddr == -1)return false;
        Class[] blackListCopy = Arrays.copyOf(getBlackList(),getBlackList().length);
        blackListCopy[cellAddr] = null;
        setBlackList(blackListCopy);
        return true;
    }

    public int searchName(Class className){
        for(int i = 0;i < getBlackList().length;i++){
            if(getBlackList()[i] != null && getBlackList()[i].equals(className))return i;
        }
        return -1;
    }
/*
*    Метод: поиск null в списке
*/
    public int searchNull(){
        if(getBlackList() == null)return -1;
            for(int i = 0;i < getBlackList().length;i++){
            if(getBlackList()[i] == null)return i;
        }
        return -1;
    }
    public boolean searchBClass(Class sClass){
        for(Class element : getBlackList()){
           if(element.equals(sClass))return true;
        }
        return false;
    }

    }
