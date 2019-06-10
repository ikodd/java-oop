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

/*public String toString(){
        for(st:this.students){

        }
}*/

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
//Метод: удаление записи
public void delStudent(Student st){
        //Если студент не найден
    if(searchStudent(st)==-1){
        System.out.println("Такой записи не обнаружено");
    return;
    }else{
        //Иначе ячейка перезаписывается значением null
        this.students[searchStudent(st)] = null;
        return;
    }
}
//Метод: поиск студента среди записей группы
public int searchStudent(Student st){
        for(int i = 0;i<this.students.length;i++){
            //При совпадении искомого значения с записью возвращается номер записи (индекс)
            if(this.students[i]==st){

                return i;
            }else if(i>=this.students.length-1&&!(this.students[i]==st)){
                return -1;//Если студент не найден
            }

        }
    return 0;
}

public int searchByLName(String lastName){
        for(int i = 0;i < this.students.length;i++){
            //При совпадении фамилии, возвращается номер записи (индекс)
            if(this.students[i].getlName().equals(lastName)){
                return i;
            }else if(i >= this.students.length -1 && !(this.students[i].getlName().equals(lastName))){
                return -1;//Если фамилия студента не найдена
            }
        }
        return 0;
}
//Метод: поиск и вывод записи по индексу в массиве
public void resultByIndex(int index){
    System.out.println(this.students[index]);
}

//Метод: проверка, заполнен ли массив записей группы студентов
public int checkList(){
        for(int i = 0;i<this.students.length;i++){
            //Если найдена пустая ячейка, возвращается её индекс
            if(this.students[i]==null){
                return i;
                //Если массив полностью заполнен возвращается -1
            }else if(i>=this.students.length-1&&!(this.students[i]==null)){
                return -1;
            }
        }
    return 0;
}

}
