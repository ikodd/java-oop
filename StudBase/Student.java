package joop;

public class Student extends Human {
    private int studyYear;//Год обучения
    private int studId;//Номер зачетки



    public Student(String lName, String fName, String sName, double height,double weight,int age,String sex, int studyYear, int studId) {
        super(lName,fName,sName,height,weight,age,sex);
        this.studyYear = studyYear;
        this.studId = studId;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studyYear=" + studyYear +
                ", studId=" + studId +
                ", lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                ", sName='" + sName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
