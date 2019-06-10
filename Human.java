package joop;

public class Human {
    protected String lName;
    protected String fName;
    protected String sName;
    protected double height;
    protected double weight;
    protected int age;
    protected String sex;

    public Human(String lName, String fName, String sName, double height, double weight, int age, String sex) {
        super();
        this.lName = lName;
        this.fName = fName;
        this.sName = sName;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
    }

    public Human(){
        super();
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Описание человека\r\n" +
                "Рост: " + this.getHeight() +
                "\r\nВес: " + this.getWeight() +
                "\r\nИмя: " + this.getAge() +
                "\r\nПол: " + this.getSex();
    }


    public String humInfo() {
        return "Описание человека\r\n" +
                "Фамилия: " + this.getlName() +
                "\r\nИмя: " + this.getfName() +
                "\r\nОтчество: " + this.getsName() +
                "\r\nПол: " + this.getSex() +
                "\r\nРост: " + this.getHeight() +
                "\r\nВес: " + this.getWeight() +
                "\r\nВозраст: " + this.getAge();
    }

}
