package joop;

import java.util.Arrays;

public class Group {
    private String grName;
    private Student []students = new Student[10];

    public Group(String grName, Student[] students) {
        super();
        this.grName = grName;
        this.students = students;
    }
    public Group(String grName){
        super();
        this.grName = grName;
    }

    public Group(){
        super();
    }

    public String getGrName() {
        return grName;
    }

    public void setGrName(String grName) {
        this.grName = grName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "grName='" + this.getGrName() + '\'' +
                ", students=" + Arrays.toString(this.getStudents()) +
                '}';

}


public void addStudent (Student st) throws FullArrException{
    try{
        if(checkList()==-1){
            throw new FullArrException("Группа заполнена");
                    }
        this.students[checkList()]=st;
            }catch(FullArrException e){
        System.out.println("Группа " + "\"" + this.getGrName() + "\"" + " заполнена: " + e);
    }


}
//Метод: удаление записи в массиве students объекта класса Group
public void delStudent(Student st){
        //Если студент не найден
    if(searchStudent(st)==-1){
        System.out.println("Такой записи не обнаружено");
    return;
    }
        //Иначе ячейка перезаписывается значением null
        this.students[searchStudent(st)] = null;
        return;

}
//Метод: поиск студента среди записей группы
public int searchStudent(Student st){
        for(int i = 0;i<this.students.length;i++){
            if(this.students[i]==null)continue;
            //При совпадении искомого значения с записью возвращается номер записи (индекс)
            if(this.students[i].equals(st))return i;

        }
    return -1;//Если студент не найден
    }

public int searchByLName(String lastName){
        for(int i = 0;i < this.students.length;i++){
            //При совпадении фамилии, возвращается номер записи (индекс)
            if(this.students[i]==null)continue;//Если в текущей строке нет записи, перейти к следующей итерации
            if(this.students[i].getlName().equals(lastName))return i;//Если фамилия найдена, возвращается индекс
                  }
    return -1;//Если фамилия студента не найдена
}

//Метод: поиск и вывод записи по индексу в массиве
public void resultByIndex(int index){
    System.out.println(this.students[index]!=null?this.students[index]:"Нет такой записи");
}

//Метод: проверка, заполнен ли массив записей группы студентов
public int checkList(){
        for(int i = 0;i<this.students.length;i++){
            //Если найдена пустая ячейка, возвращается её индекс
            if(this.students[i]==null)return i;
        }
    //Если массив полностью заполнен возвращается -1
    return -1;
}

//Метод: сортировка записей массива класса Group
   public void sort(){
for(int i = 0;i < this.students.length;i++){
    if(this.students[i]==null)continue;
    Student objMin = this.students[i];
    int minIndex = i;
    for(int j = i;j<this.students.length - 1;j++){
         if(objMin.getlName().compareTo(this.students[j].getlName())>0){
          objMin = this.students[j];
          minIndex = j;
      }
    }
    if(minIndex != i){
        this.students[minIndex] = this.students[i];
        this.students[i] = objMin;
    }
}
   }

}
