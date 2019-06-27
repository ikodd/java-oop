package joop;

import sun.plugin.viewer.context.IExplorerAppletContext;

import java.io.*;
import java.util.Arrays;

public class Group implements Commissar, Serializable {
    private static final long serialVersionUID = 1L;
    private String grName;
    private String grFName; // Название файла базы данных группы
    private Student []students = new Student[10];

    public Group(String grName, String grFName, Student[] students) {
        super();
        this.grName = grName;
        this.grFName = grFName;
        this.students = students;
    }
    public Group(String grName,String grFName){
        super();
        this.grName = grName;
        this.grFName = grFName;
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

    public String getGrFName() {
        return grFName;
    }

    public void setGrFName(String grFName) {
        this.grFName = grFName;
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


public boolean addStudent (Student st) throws FullArrException, IOException{
    try{
        if(checkList()==-1){
            throw new FullArrException("Группа заполнена");
                    }
        this.students[checkList()] = st;
        storeGrData();
        return true;
            }catch(FullArrException e){
        System.out.println("Группа " + "\"" + this.getGrName() + "\"" + " заполнена: " + e);
    }

return false;
}
//Метод: удаление записи в массиве students объекта класса Group
public boolean delStudent(Student st){
        //Если студент не найден
    if(searchStudent(st) == -1){
        System.out.println("Такой записи не обнаружено");
    return false;
    }
        //Иначе ячейка перезаписывается значением null
        this.students[searchStudent(st)] = null;
        return true;

}
//Метод: поиск студента среди записей группы
public int searchStudent(Student st){
        for(int i = 0;i < this.students.length;i++){
            //При совпадении искомого значения с записью возвращается номер записи (индекс)
            if(this.students[i] != null && this.students[i].equals(st))return i;
        }
    return -1; // Если студент не найден
}

/*
* Метод: поиск студента по номеру зачетки
*/
public Student searchStByID(int id) throws NullPointerException{
   try{
       for(Student st : getStudents()){
           if(st != null && st.getStudId() == id){
               return st;
           }
       }
   }catch(NullPointerException e){
       e.printStackTrace();
   }

   return null;
}

public int searchByLName(String lastName){
        for(int i = 0;i < this.students.length;i++){
            //При совпадении фамилии, возвращается номер записи (индекс)
            if(this.students[i] != null && this.students[i].getlName().equals(lastName))return i;//Если фамилия найдена, возвращается индекс
                  }
    return -1;//Если фамилия студента не найдена
}

//Метод: поиск и вывод записи по индексу в массиве
public void resultByIndex(int index){
    System.out.println((this.students[index]!= null) ? this.students[index] : "Нет такой записи");
}

//Метод: проверка, заполнен ли массив записей группы студентов
public int checkList(){
        for(int i = 0;i<this.students.length;i++){
            //Если найдена пустая ячейка, возвращается её индекс
            if(this.students[i] == null)return i;
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
         if(this.students[j] != null && objMin.getlName().compareTo(this.students[j].getlName())>0){
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
/*
*    Метод: сортировка по параметру
*    Если reverse = false – восходящий
*/
public void sortByPar(boolean reverse, int sortPar){
        Arrays.sort(this.students,new StudentComparator(reverse,sortPar));

   }

   //Метод для интерфейса Commissar
  public Student[] getRecruits() throws NullPointerException {
      int num = 0;//Резервирование счетчика для для возвращаемого массива

         for(Student st : getStudents()){
         if(st != null && st.getAge() >= 18 && st.getSex().equals("мужской")){
             num+= 1;//При совпадении условий, обновление счетчика
         }
         }
        //Если таких нет, возвращается null
      if(num == 0) return null;

      //Иначе создается массив с количеством строк num
      Student[] arrRecruits = new Student[num];
      int i = 0;//Резервирование счетчика итераций при заполнении массива

      //Перебор строк массива студентов группы
         for(Student st : getStudents()) {
              if (st != null && st.getAge() >= 18 && st.getSex().equals("мужской")) {
                  //Данные студента, отвечающего требованиям, помещаются в массив
                  arrRecruits[i] = st;
                  i+= 1;//Обновление счетчика итераций
              }
          }
         //Возвращение массива данных студентов, отвечающих требованиям военкома
         return arrRecruits;
        }
/*
*    Метод:
*   сохранение данных группы в файл (сериализация)
*   При успешном сохранении – true
*/
public boolean storeGrData() throws IOException {
            File f = new File(System.getProperty("user.dir") + "/src/joop/" + getGrFName());
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
    oos.writeObject(this);
    return true;
}catch (IOException e){
                e.printStackTrace();
            }
            return false;
        }
/*
*    Метод: чтение базы данных группы из файла (десериализация)
*    На входе имя файла
*/
public static Group readGrDataByFName(String fName) throws IOException,ClassNotFoundException{
            Group gr = new Group();
            gr = null;
            File f = new File(System.getProperty("user.dir") + "/src/joop/" + fName);
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream((f)))){
               gr = (Group)ois.readObject();
               return gr;
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
            return null;
        }
/*
*   Метод: удаление из базы группы записи студента
*
*  */
        public boolean delStudById(int id) throws IOException{
    Student st = searchStByID(id);
    if(st != null){
        delStudent(st);
        storeGrData();
        return true;
    }
    return false;
        }

public void printGroup(){
    for(Student st : this.getStudents()){
        System.out.println(st);
    }
}
}
