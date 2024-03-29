package joop;
/*
*   Сериализация-десериализация объектов
*/

import java.io.IOException;
import java.util.Arrays;

import static joop.Group.readGrDataByFName;


public class HomeW0606  {
    public static void main(String[] args) throws FullArrException, IOException, ClassNotFoundException,NullPointerException {
        Human stud1 = new Student("Иванов", "Иван", "Иванович",176, 80,21,"мужской",1,644654);
        Human stud2 = new Student("Петрова", "Мария", "Ивановна",172,65,20,"женский",1,545455454);
        Human stud3 = new Student("Тропиканов", "Авдей", "Михайлович",190,70,27,"мужской",2,3555545);
        Human stud4 = new Student("Алмазова", "Авдотья", "Степановна",175,74,23,"женский",1,545455454);
        Human stud5 = new Student("Федоров", "Кирилл", "Наумович",180,80,21,"мужской",2,544445454);
        Human stud6 = new Student("Хлопонина", "Роза", "Федоровна",165,56,19,"женский",1,8761152);
        Human stud7 = new Student("Голенищев", "Лука", "Мартынович",176,71,22,"мужской",1,522555454);
        Human stud8 = new Student("Коромысло", "Варвара", "Пафнутьевна",167,65,25,"женский",2,547755454);
        Human stud9 = new Student("Костылев", "Парамон", "Колеватович",185,83,22,"мужской",1,545455334);
        Human stud10 = new Student("Стрекоза", "Валерия", "Александровна",175,73,20,"женский",1,545455464);
        Human stud11 = new Student("Мысливцев", "Кондрат", "Филатович",169,76,22,"мужской",2,542455456);
        Human stud12 = new Student("Нарядная", "Алла", "Борисовна",170,69,21,"женский",1,545488454);
        Group gr1 = new Group("Английский язык","grEng");
        Group gr2 = new Group("Французский язык","grFr");
        gr1.addStudent((Student)stud1);
        gr2.addStudent(null);
        gr1.addStudent((Student)stud3);
        gr1.addStudent((Student) stud4);
        gr1.addStudent((Student) stud5);
        gr1.addStudent((Student) stud6);
        gr1.addStudent((Student) stud7);
        gr1.addStudent((Student) stud8);
        gr1.addStudent((Student) stud9);
        gr1.addStudent((Student) stud10);
        gr1.addStudent((Student) stud11);
        
gr1.storeGrData();
Group grTemp = new Group();
           grTemp = readGrDataByFName("grEng");
           grTemp.printGroup();
        //Удаление из базы группы по номер студ. зачетки
        gr1.delStudById(545455454);
        gr1.printGroup();
        gr1.addStudent((Student)stud1);
        gr1.storeGrData();
        grTemp = readGrDataByFName("grEng");
        grTemp.printGroup();

    }
}
