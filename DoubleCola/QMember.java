package joop.collections;

/*
*   Класс для Шелдона и Ко. с двойной колой
*/

public class QMember {
    private String name;

    public QMember(String name) {
        super();
        this.name = name;
    }
    public QMember() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QMember{" +
                "name='" + name + '\'' +
                '}';
    }
}
